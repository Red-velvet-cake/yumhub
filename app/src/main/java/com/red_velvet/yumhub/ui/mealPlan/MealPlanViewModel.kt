package com.red_velvet.yumhub.ui.mealPlan

import com.red_velvet.yumhub.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MealPlanViewModel @Inject constructor() : BaseViewModel<MealPlanUiState, MealPlanUiEffect>(
    MealPlanUiState()
) {}