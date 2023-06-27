package com.red_velvet.yumhub.ui.mealPlan.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MealPlanPagerAdapter(
    container: Fragment,
    private val fragmentsList: List<Fragment>
) : FragmentStateAdapter(container) {

    override fun getItemCount(): Int = fragmentsList.size

    override fun createFragment(position: Int): Fragment = fragmentsList[position]
}