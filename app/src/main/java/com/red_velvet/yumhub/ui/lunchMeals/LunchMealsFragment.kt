package com.red_velvet.yumhub.ui.lunchMeals

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentLunchMealsBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import com.red_velvet.yumhub.ui.mealPlan.MealPlanUiEffect
import com.red_velvet.yumhub.ui.mealPlan.MealPlanUiState
import com.red_velvet.yumhub.ui.mealPlan.MealPlanViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LunchMealsFragment :
    BaseFragment<FragmentLunchMealsBinding, MealPlanUiState, MealPlanUiEffect, MealPlanViewModel>() {
    override val layoutIdFragment: Int = R.layout.fragment_lunch_meals
    override val viewModel: MealPlanViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLunchMealsAdapter()
    }

    override fun observeOnUIEffects() {}

    override fun handleUIEffect(uiEffect: MealPlanUiEffect) {}

    private fun initLunchMealsAdapter() {
        val adapter = LunchMealsAdapter(emptyList(), viewModel)
        binding.recyclerLunchMeals.adapter = adapter
    }

}