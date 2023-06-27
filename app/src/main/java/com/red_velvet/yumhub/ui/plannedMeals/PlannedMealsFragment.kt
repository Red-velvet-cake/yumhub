package com.red_velvet.yumhub.ui.plannedMeals

import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentPlannedMealsBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlannedMealsFragment :
    BaseFragment<FragmentPlannedMealsBinding, PlannedMealsUiState, PlannedMealsUiEffect, PlannedMealsViewModel>() {
    override val layoutIdFragment: Int = R.layout.fragment_planned_meals
    override val viewModel: PlannedMealsViewModel by viewModels()

    override fun observeOnUIEffects() {
    }

    override fun handleUIEffect(uiEffect: PlannedMealsUiEffect) {
    }

}