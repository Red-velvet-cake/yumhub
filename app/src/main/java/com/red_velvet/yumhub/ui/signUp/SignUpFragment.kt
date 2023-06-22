package com.red_velvet.yumhub.ui.signUp


import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentSignUpBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SignUpFragment :
    BaseFragment<FragmentSignUpBinding, SignUpUIState, SignupUIEffect, SignUpViewModel>() {
    override val layoutIdFragment = R.layout.fragment_sign_up
    override val viewModel: SignUpViewModel by viewModels()

    override fun observeOnUIEffects() {
        lifecycleScope.launch {
            when (viewModel.effect.first()) {
                SignupUIEffect.LoggedInSuccessfully -> {
                    findNavController().navigate(R.id.homeFragment)
                }
            }
        }
    }

    override fun handleUIEffect(uiEffect: SignupUIEffect) {
//        TODO("Not yet implemented")
    }

}