package com.red_velvet.yumhub.ui.mealPlan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentMealPlanBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
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
    private lateinit var pagerAdapter: MealPlanPagerAdapter
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
            initMealsPager()
            initTabLayout(tabsTitles)
            initCalendarDaysAdapter()
            listenToTabSelection()
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

    private fun initMealsPager() {
        pagerAdapter = MealPlanPagerAdapter(this)
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

    private fun listenToTabSelection() {
        binding.tabLayoutMealType.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    viewModel.onPageChanged(it.position + 1)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}