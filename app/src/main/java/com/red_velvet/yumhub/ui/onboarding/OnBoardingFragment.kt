package com.red_velvet.yumhub.ui.onboarding

import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentOnboardingBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingFragment  : BaseFragment<FragmentOnboardingBinding, OnBoardingUIState, OnBoardingViewModel>() {
    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_onboarding
    override val viewModel: OnBoardingViewModel by viewModels()
}