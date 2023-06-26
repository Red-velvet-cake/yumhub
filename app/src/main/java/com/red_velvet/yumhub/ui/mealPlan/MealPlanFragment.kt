package com.red_velvet.yumhub.ui.mealPlan

import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentMealPlanBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealPlanFragment :
    BaseFragment<FragmentMealPlanBinding, MealPlanUiState, MealPlanUiEffect, MealPlanViewModel>() {
    override val layoutIdFragment: Int = R.layout.fragment_meal_plan
    override val viewModel: MealPlanViewModel by viewModels()

    override fun observeOnUIEffects() {}

    override fun handleUIEffect(uiEffect: MealPlanUiEffect) {}
}