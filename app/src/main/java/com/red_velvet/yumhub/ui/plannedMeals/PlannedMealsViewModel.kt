package com.red_velvet.yumhub.ui.plannedMeals

import com.red_velvet.yumhub.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PlannedMealsViewModel @Inject constructor() :
    BaseViewModel<PlannedMealsUiState, PlannedMealsUiEffect>(PlannedMealsUiState()),
    PlannedMealsInteractionListener {

    fun getPlannedMeals(meals: List<PlannedMealsUiState.MealUiState>) {
        _state.update { it.copy(isLoading = true) }
        _state.update { it.copy(meals = meals) }
        _state.update { it.copy(isLoading = false) }
    }

    override fun onMealClicked(meal: PlannedMealsUiState.MealUiState) {}
}