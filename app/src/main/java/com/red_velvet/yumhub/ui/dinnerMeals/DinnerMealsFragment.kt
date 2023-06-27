package com.red_velvet.yumhub.ui.dinnerMeals

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentDinnerMealsBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import com.red_velvet.yumhub.ui.mealPlan.MealPlanUiEffect
import com.red_velvet.yumhub.ui.mealPlan.MealPlanUiState
import com.red_velvet.yumhub.ui.mealPlan.MealPlanViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DinnerMealsFragment :
    BaseFragment<FragmentDinnerMealsBinding, MealPlanUiState, MealPlanUiEffect, MealPlanViewModel>() {
    override val layoutIdFragment: Int = R.layout.fragment_dinner_meals
    override val viewModel: MealPlanViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPlannedMealsAdapter()
    }

    override fun observeOnUIEffects() {}

    override fun handleUIEffect(uiEffect: MealPlanUiEffect) {}

    private fun initPlannedMealsAdapter() {
        val adapter = DinnerMealsAdapter(emptyList(), viewModel)
        binding.recyclerDinnerMeals.adapter = adapter
    }

}