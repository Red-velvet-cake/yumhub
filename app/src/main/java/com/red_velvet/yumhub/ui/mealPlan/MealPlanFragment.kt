package com.red_velvet.yumhub.ui.mealPlan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentMealPlanBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import com.red_velvet.yumhub.ui.breakfastMeals.BreakfastMealsFragment
import com.red_velvet.yumhub.ui.dinnerMeals.DinnerMealsFragment
import com.red_velvet.yumhub.ui.lunchMeals.LunchMealsFragment
import com.red_velvet.yumhub.ui.mealPlan.adapter.CalendarDaysAdapter
import com.red_velvet.yumhub.ui.mealPlan.adapter.MealPlanPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MealPlanFragment :
    BaseFragment<FragmentMealPlanBinding, MealPlanUiState, MealPlanUiEffect, MealPlanViewModel>() {
    override val layoutIdFragment: Int = R.layout.fragment_meal_plan
    override val viewModel: MealPlanViewModel by viewModels()
    private val mealsFragmentList = listOf(
        BreakfastMealsFragment(),
        LunchMealsFragment(),
        DinnerMealsFragment(),
    )
    private val tabsTitles = listOf(
        R.string.breakfast,
        R.string.lunch,
        R.string.dinner
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return super.onCreateView(inflater, container, savedInstanceState).also {
            initMealsPager(mealsFragmentList)
            initTabLayout(tabsTitles)
            initCalendarDaysAdapter()
        }
    }

    override fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collectLatest { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: MealPlanUiEffect) {
        when (uiEffect) {
            is MealPlanUiEffect.ShowMealDetails -> navigateToMealDetails(uiEffect.mealId)
        }
    }

    private fun navigateToMealDetails(mealId: Int) {
        val action =
            MealPlanFragmentDirections.actionMealPlanFragmentToRecipeInformationFragment(mealId)
        findNavController().navigate(action)
    }

    private fun initMealsPager(fragments: List<Fragment>) {
        val pagerAdapter = MealPlanPagerAdapter(this, fragments, viewModel)
        binding.viewPagerMeals.adapter = pagerAdapter
    }

    private fun initTabLayout(titles: List<Int>) {
        TabLayoutMediator(binding.tabLayoutMealType, binding.viewPagerMeals) { tab, position ->
            tab.text = getString(titles[position])
        }.attach()
    }


    private fun initCalendarDaysAdapter() {
        val calendarDaysAdapter = CalendarDaysAdapter(emptyList(), viewModel)
        binding.recyclerViewCalendarDays.adapter = calendarDaysAdapter
    }
}