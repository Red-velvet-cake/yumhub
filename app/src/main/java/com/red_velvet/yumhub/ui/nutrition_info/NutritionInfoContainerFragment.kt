package com.red_velvet.yumhub.ui.nutrition_info

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.tabs.TabLayoutMediator
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentTestYourMealBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import com.red_velvet.yumhub.ui.nutrition_info_type_bad.BadNutritionInfoFragment
import com.red_velvet.yumhub.ui.nutritionl_info_type_good.GoodNutritionInfoFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NutritionInfoContainerFragment :
    BaseFragment<FragmentTestYourMealBinding,
            NutritionInfoUiState,
            NutritionInfoUiEffect,
            NutritionInfoViewModel>() {

   private val fragmentsList = listOf(BadNutritionInfoFragment(), GoodNutritionInfoFragment())
   private val tabTitles = listOf("good", "bad")


    override val layoutIdFragment = R.layout.fragment_test_your_meal

    override val viewModel: NutritionInfoViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()
        initTabLayout()
    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }
    }

    override fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collectLatest { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: NutritionInfoUiEffect) {
//        to do
    }

    private fun initViewPager() {
        val pagerAdapter = ViewPagerAdapter(this, fragmentsList)
        binding.viewPager.adapter = pagerAdapter
    }


}