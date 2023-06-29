package com.red_velvet.yumhub.ui.mealPlan.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.red_velvet.yumhub.ui.mealPlan.MealPlanInteractionListener
import com.red_velvet.yumhub.ui.plannedMeals.PlannedMealsFragment

class MealPlanPagerAdapter(
    container: Fragment,
    private val listener: MealPlanInteractionListener
) : FragmentStateAdapter(container) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment = PlannedMealsFragment()

    override fun getItemId(position: Int): Long {
        listener.onPageChanged(position)
        return super.getItemId(position)
    }

}