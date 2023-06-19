package com.red_velvet.ui.onboarding

import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import com.red_velvet.mylibrary.R
import com.red_velvet.mylibrary.databinding.FragmentOnboardingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingFragment  : com.red_velvet.ui.base.BaseFragment<FragmentOnboardingBinding, OnBoardingUIState, OnBoardingViewModel>() {
    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_onboarding
    override val viewModel: OnBoardingViewModel by viewModels()
}