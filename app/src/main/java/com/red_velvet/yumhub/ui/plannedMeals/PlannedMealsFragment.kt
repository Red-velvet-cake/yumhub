package com.red_velvet.yumhub.ui.plannedMeals

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentPlannedMealsBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import com.red_velvet.yumhub.ui.mealPlan.MealPlanFragmentDirections
import com.red_velvet.yumhub.ui.mealPlan.MealPlanViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PlannedMealsFragment :
    BaseFragment<FragmentPlannedMealsBinding, PlannedMealsUiState, PlannedMealsUiEffect, PlannedMealsViewModel>() {
    override val layoutIdFragment: Int = R.layout.fragment_planned_meals
    override val viewModel: PlannedMealsViewModel by viewModels()
    private val sharedViewModel: MealPlanViewModel by viewModels({ requireParentFragment() })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPlannedMealsAdapter()
    }

    override fun observeOnUIEffects() {

        observeOnSelectedTab()
        lifecycleScope.launch { viewModel.effect.collectLatest { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: PlannedMealsUiEffect) {
        when (uiEffect) {
            is PlannedMealsUiEffect.ShowMealDetails -> navigateToMealDetails(uiEffect.id)
        }
    }

    private fun initPlannedMealsAdapter() {
        val adapter = PlannedMealsAdapter(emptyList(), viewModel)
        binding.recyclerMeals.adapter = adapter
    }

    private fun navigateToMealDetails(mealId: Int) {
        val action =
            MealPlanFragmentDirections.actionMealPlanFragmentToRecipeInformationFragment(mealId)
        findNavController().navigate(action)
    }

    private fun observeOnSelectedTab() {
        lifecycleScope.launch {
            sharedViewModel.state.collect { state ->
                when (state.pagePosition) {
                    2 -> viewModel.getPlannedMeals(state.lunchMeals.toPlannedMealUiState())
                    3 -> viewModel.getPlannedMeals(state.dinnerMeals.toPlannedMealUiState())
                    else -> viewModel.getPlannedMeals(state.breakfastMeals.toPlannedMealUiState())
                }
            }
        }
    }

}