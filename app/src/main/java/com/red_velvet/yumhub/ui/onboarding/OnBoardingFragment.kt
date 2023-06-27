package com.red_velvet.yumhub.ui.onboarding

import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentOnboardingBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class OnBoardingFragment :
    BaseFragment<FragmentOnboardingBinding, OnBoardingUIState, OnBoardingUIEffect, OnBoardingViewModel>() {
    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_onboarding
    override val viewModel: OnBoardingViewModel by viewModels()
    override fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collectLatest { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: OnBoardingUIEffect) {
        when (uiEffect) {
            OnBoardingUIEffect.ClickOnGoToSignup -> onGoToSignup()
        }
    }

    private fun onGoToSignup() {
        val directions = OnBoardingFragmentDirections.actionOnBoardingFragmentToSignupFragment()
        findNavController().navigate(directions)
    }
}