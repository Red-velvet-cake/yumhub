package com.red_velvet.yumhub.ui.plannedMeals

import com.red_velvet.yumhub.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlannedMealsViewModel @Inject constructor() :
    BaseViewModel<PlannedMealsUiState, PlannedMealsUiEffect>(PlannedMealsUiState()),
    PlannedMealsInteractionListener {
}