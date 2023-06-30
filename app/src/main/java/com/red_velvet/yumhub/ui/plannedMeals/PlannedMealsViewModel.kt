package com.red_velvet.yumhub.ui.plannedMeals

import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
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

    override fun onMealClicked(id: Int) {
        viewModelScope.launch { _effect.emit(PlannedMealsUiEffect.ShowMealDetails(id)) }
    }
}