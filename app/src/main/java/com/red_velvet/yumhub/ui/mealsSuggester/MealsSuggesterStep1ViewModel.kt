package com.red_velvet.yumhub.ui.mealsSuggester

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.FoodSystemEntity
import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.domain.usecases.CalculateNeededCaloriesUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import com.red_velvet.yumhub.ui.mealsSuggester.mealSuggesterStep1.MealsSuggesterStep1UiEffect
import com.red_velvet.yumhub.ui.mealsSuggester.mealSuggesterStep2.MealsSuggesterStep2UiEffect
import com.red_velvet.yumhub.ui.mealsSuggester.mealsSuggesterStep3.MealsSuggesterStep3UiEffect
import com.red_velvet.yumhub.ui.mealsSuggester.mealsSuggesterStep3.SuggestedMealsInteractionListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsSuggesterStep1ViewModel @Inject constructor(
    private val calculateNeededCaloriesUseCase: CalculateNeededCaloriesUseCase,
) : BaseViewModel<MealsSuggesterStep1UiState>(MealsSuggesterStep1UiState()),SuggestedMealsInteractionListener {
    private val _effectStepOne = MutableSharedFlow<MealsSuggesterStep1UiEffect>()
    val effectStepOne = _effectStepOne.asSharedFlow()
    private val _effectTwo = MutableSharedFlow<MealsSuggesterStep2UiEffect>()
    val effectTwo = _effectTwo.asSharedFlow()
    private val _effectStepThree = MutableSharedFlow<MealsSuggesterStep3UiEffect>()
    val effectStepThree = _effectStepThree.asSharedFlow()

    fun updateGender(gender: String)
    {
        _state.update { it.copy(gender = gender) }
        viewModelScope.launch { _effectStepOne.emit(
            MealsSuggesterStep1UiEffect.ClickOnGenderSelector(
                gender
            )
        ) }
    }
     fun updateActivityLevel(activityLevel: String)
    {
        _state.update { it.copy(activityLevel = activityLevel) }
        viewModelScope.launch { _effectStepOne.emit(
            MealsSuggesterStep1UiEffect.ClickOnActivityLevelSelector(
                activityLevel
            )
        ) }
    }


    fun updateGoal(goal: String) {
        _state.update { it.copy(goal = goal) }
        viewModelScope.launch { _effectTwo.emit(MealsSuggesterStep2UiEffect.ClickOnGoalSelector(goal)) }
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


}