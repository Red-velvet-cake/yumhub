package com.red_velvet.yumhub.ui.signUp


import android.os.Bundle
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
class SignUpFragment : BaseFragment<FragmentSignUpBinding, SignUpUIState, SignUpViewModel>() {
    override val layoutIdFragment = R.layout.fragment_sign_up
    override val viewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeUIEvents()
    }

    private fun observeUIEvents() {
        lifecycleScope.launch {
            when (viewModel.effect.first()) {
                SignupUIEffect.LoggedInSuccessfully -> {
                    findNavController().navigate(R.id.homeFragment)
                }
            }
        }
    }
}