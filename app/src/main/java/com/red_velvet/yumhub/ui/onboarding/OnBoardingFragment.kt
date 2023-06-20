package com.red_velvet.yumhub.ui.onboarding

import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentOnboardingBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingFragment :
    BaseFragment<FragmentOnboardingBinding, OnBoardingUIState, OnBoardingUIEffect, OnBoardingViewModel>() {
    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_onboarding
    override val viewModel: OnBoardingViewModel by viewModels()
    override fun observeOnUIEffects() {
//        TODO("Not yet implemented")
    }

    override fun handleUIEffect(uiEffect: OnBoardingUIEffect) {
//        TODO("Not yet implemented")
    }
}