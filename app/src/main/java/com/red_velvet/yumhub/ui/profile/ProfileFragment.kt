package com.red_velvet.yumhub.ui.profile

import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentProfileBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment :
    BaseFragment<FragmentProfileBinding, ProfileUiState, ProfileUiEffect, ProfileViewModel>() {
    override val layoutIdFragment = R.layout.fragment_profile
    override val viewModel: ProfileViewModel by viewModels()

    override fun observeOnUIEffects() {}

    override fun handleUIEffect(uiEffect: ProfileUiEffect) {}

}