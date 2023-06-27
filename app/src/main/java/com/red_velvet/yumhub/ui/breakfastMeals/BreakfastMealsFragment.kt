package com.red_velvet.yumhub.ui.breakfastMeals

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentBreakfastMealsBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import com.red_velvet.yumhub.ui.mealPlan.MealPlanUiEffect
import com.red_velvet.yumhub.ui.mealPlan.MealPlanUiState
import com.red_velvet.yumhub.ui.mealPlan.MealPlanViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreakfastMealsFragment :
    BaseFragment<FragmentBreakfastMealsBinding, MealPlanUiState, MealPlanUiEffect, MealPlanViewModel>() {
    override val layoutIdFragment: Int = R.layout.fragment_breakfast_meals
    override val viewModel: MealPlanViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPlannedMealsAdapter()
    }

    override fun observeOnUIEffects() {}

    override fun handleUIEffect(uiEffect: MealPlanUiEffect) {}

    private fun initPlannedMealsAdapter() {
        val adapter = BreakfastMealsAdapter(emptyList(), viewModel)
        binding.recyclerBreakfastMeals.adapter = adapter
    }

}