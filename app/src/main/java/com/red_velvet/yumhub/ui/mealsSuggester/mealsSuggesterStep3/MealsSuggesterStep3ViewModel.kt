package com.red_velvet.yumhub.ui.mealsSuggester.mealsSuggesterStep3

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.FoodSystemEntity
import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.domain.usecases.CalculateNeededCaloriesUseCase
import com.red_velvet.yumhub.ui.base.BaseInteractionListener
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsSuggesterStep3ViewModel @Inject constructor(
    private val calculateNeededCaloriesUseCase: CalculateNeededCaloriesUseCase,
) : BaseViewModel<MealsSuggesterStep3UiState>(MealsSuggesterStep3UiState()), SuggestedMealsInteractionListener {
    private val _effect = MutableSharedFlow<MealsSuggesterStep3UiEffect>()
    val effect = _effect.asSharedFlow()
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
            ))},
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

    /*
          fun updateGender(gender: String)
        {
            _state.update { it.copy(gender = gender) }
            viewModelScope.launch { _effect.emit(MealsSuggesterStep3UiEffect.ClickOnGenderSelector(gender)) }
        }
         fun updateActivityLevel(activityLevel: String)
        {
            _state.update { it.copy(activityLevel = activityLevel) }
            viewModelScope.launch { _effect.emit(MealsSuggesterStep3UiEffect.ClickOnActivityLevelSelector(activityLevel)) }
        }*/

    }