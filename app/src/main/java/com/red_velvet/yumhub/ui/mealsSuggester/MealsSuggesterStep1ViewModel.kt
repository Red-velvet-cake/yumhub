package com.red_velvet.yumhub.ui.mealsSuggester

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.FoodSystemEntity
import com.red_velvet.yumhub.domain.models.recipes.RangeNeededCaloriesEntity
import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.domain.usecases.CalculateNeededCaloriesUseCase
import com.red_velvet.yumhub.domain.usecases.CalculateRangeOfNeededCaloriesUseCase
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import com.red_velvet.yumhub.ui.mealsSuggester.mealsSuggesterStep3.SuggestedMealsInteractionListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsSuggesterStep1ViewModel @Inject constructor(
    private val calculateNeededCaloriesUseCase: CalculateNeededCaloriesUseCase,
    private val calculateRangeOfNeededCaloriesUseCase: CalculateRangeOfNeededCaloriesUseCase
) : BaseViewModel<MealsSuggesterStep1UiState, MealsSuggesterStep1UiEffect>(
    MealsSuggesterStep1UiState()
), SuggestedMealsInteractionListener {
    fun updateGender(gender: String) {
        _state.update { it.copy(gender = gender) }
        viewModelScope.launch {
            _effect.emit(MealsSuggesterStep1UiEffect.ClickOnGenderSelector(gender))
        }
    }
     fun updateActivityLevel(activityLevel: Int)
    {
        _state.update { it.copy(activityLevel = activityLevel) }
        viewModelScope.launch {
            _effect.emit(MealsSuggesterStep1UiEffect.ClickOnActivityLevelSelector(activityLevel))
        }
    }

    fun updateGoal(goal: String) {
        _state.update { it.copy(goal = goal) }
        viewModelScope.launch { _effect.emit(MealsSuggesterStep1UiEffect.ClickOnGoalSelector(goal)) }
    }

    fun updateTall(tall: String) {
        if (tall!="")
            _state.update { it.copy(tall = tall.toInt()) }
        else
            _state.update { it.copy(tall = -1) }
    }

    fun updateAge(age: String) {
        if (age!="")
            _state.update { it.copy(age = age.toInt()) }
        else
            _state.update { it.copy(age = -1) }
    }

    fun updateWeight(weight: String) {
        if (weight!="")
            _state.update { it.copy(weight = weight.toInt()) }
        else
            _state.update { it.copy(weight = -1) }
    }
    override fun onMealClick(id: Int) {

    }
    fun onSuccessFetchData(meals: List<RecipeEntity>)
    { _state.update { it.copy( meals = meals.toSuggestedMeals()) } }

    fun onError(throwable: ErrorUIState)
    { _state.update { it.copy(error = throwable) } }

     fun onNextButtonClicked(type: String) {
         if (type == "stepTwo") {
             val neededCalories =  getNeededCalories()
             _state.update { it.copy(calories = neededCalories.maximumCalories.toInt()) }
             tryToExecute(
                 { calculateNeededCaloriesUseCase.calculateNeededCalories(neededCalories) },
                 onSuccess = ::onSuccessFetchData,
                 onError = ::onError
             )
         }
         viewModelScope.launch { _effect.emit(MealsSuggesterStep1UiEffect.OnNextClicked(type)) }
     }

    private fun getNeededCalories():RangeNeededCaloriesEntity {
       return calculateRangeOfNeededCaloriesUseCase.calculateNeededCalories (
           FoodSystemEntity(
               age = _state.value.age.orZero(),
               weight = _state.value.weight.orZero(),
               height = _state.value.tall.orZero(),
               activityLevel = _state.value.activityLevel.orZero(),
               gender = _state.value.gender.orEmpty(),
               goal = _state.value.goal.orEmpty()
           )
       )
    }

}
