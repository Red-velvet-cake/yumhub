package com.red_velvet.yumhub.ui.test_your_meal

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentTestYourMealBinding
import com.red_velvet.yumhub.ui.base.BaseFragment


class TestYourMealFragment :
    BaseFragment<FragmentTestYourMealBinding,
            TestYourMealUiState,
            TestYourMealUiEffect,
            TestYourMealViewModel>() {

    private val fragmentsList = listOf(BadContentFragment(), GoodContentFragment())
   private val tabTitles = listOf("good", "bad")


    override val layoutIdFragment = R.layout.fragment_test_your_meal

    override val viewModel: TestYourMealViewModel by viewModels()


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
        TODO("Not yet implemented")
    }

    override fun handleUIEffect(uiEffect: TestYourMealUiEffect) {
        TODO("Not yet implemented")
    }

    private fun initViewPager() {
        val pagerAdapter = ViewPagerAdapter(this, fragmentsList)
        binding.viewPager.adapter = pagerAdapter
    }


}