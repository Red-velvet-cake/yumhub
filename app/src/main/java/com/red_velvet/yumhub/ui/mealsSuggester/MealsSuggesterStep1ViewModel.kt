package com.red_velvet.yumhub.ui.mealsSuggester

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.FoodSystemEntity
import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.domain.usecases.CalculateNeededCaloriesUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import com.red_velvet.yumhub.ui.mealsSuggester.mealsSuggesterStep3.SuggestedMealsInteractionListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsSuggesterStep1ViewModel @Inject constructor(
    private val calculateNeededCaloriesUseCase: CalculateNeededCaloriesUseCase,
) : BaseViewModel<MealsSuggesterStep1UiState, MealsSuggesterStep1UiEffect>(
    MealsSuggesterStep1UiState()
), SuggestedMealsInteractionListener {

    fun updateGender(gender: String) {
        _state.update { it.copy(gender = gender) }
        viewModelScope.launch {
            _effect.emit(
                MealsSuggesterStep1UiEffect.ClickOnGenderSelector(
                    gender
                )
            )
        }
    }
     fun updateActivityLevel(activityLevel: String)
    {
        _state.update { it.copy(activityLevel = activityLevel) }
        viewModelScope.launch {
            _effect.emit(
                MealsSuggesterStep1UiEffect.ClickOnActivityLevelSelector(
                    activityLevel
                )
            )
        }
        Log.i("jalal", _state.value.toString())
    }


    fun updateGoal(goal: String) {
        _state.update { it.copy(goal = goal) }
        viewModelScope.launch { _effect.emit(MealsSuggesterStep1UiEffect.ClickOnGoalSelector(goal)) }
    }

    fun updateTall(tall: String) {
        _state.update { it.copy(tall = tall.toInt()) }
    }

    fun updateAge(age: String) {
        _state.update { it.copy(age = age.toInt()) }
    }

    fun updateWeight(weight: String) {
        _state.update { it.copy(weight = weight.toInt()) }
    }

    init {
        onFetchData()
    }

    private fun onFetchData() {
        tryToExecute({calculateNeededCaloriesUseCase.calculateNeededCalories(
            FoodSystemEntity(
                age = 27,
                weight = 80,
                height = 187,
                activityLevel = 2,
                gender = "Male",
                goal = "Loss Weight"
            )
        )},
            onSuccess = ::onSuccessFetchData,
            onError = ::onError
        )
    }

    override fun onMealClick(id: Int) {

    }
    fun onSuccessFetchData(meals: List<RecipeEntity>)
    {
        _state.update { it.copy(isLoading = false, meals = meals.toSuggestedMeals()) }
        Log.i("jalal",_state.value.toString())

    }
    fun onError(throwable: ErrorUIState)
    {

    }
    fun onNextButtonClicked()
    {
        viewModelScope.launch { _effect.emit(MealsSuggesterStep1UiEffect.OnNextClicked) }
    }



}