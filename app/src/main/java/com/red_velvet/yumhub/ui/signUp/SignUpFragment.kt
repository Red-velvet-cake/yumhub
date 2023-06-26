package com.red_velvet.yumhub.ui.signUp


import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentSignUpBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SignUpFragment :
    BaseFragment<FragmentSignUpBinding, SignUpUIState, SignupUIEffect, SignUpViewModel>() {
    override val layoutIdFragment = R.layout.fragment_sign_up
    override val viewModel: SignUpViewModel by viewModels()

    override fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collect { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: SignupUIEffect) {
        when (uiEffect) {
            SignupUIEffect.LoggedInSuccessfully -> navigateToHome()
            is SignupUIEffect.ShowError -> handleError(uiEffect.error)
        }
    }

    private fun navigateToHome() {
        val action = SignUpFragmentDirections.actionSignupFragmentToHomeFragment()
        findNavController().navigate(action)
    }

    private fun handleError(error: ErrorUIState) {
        when (error) {
            is ErrorUIState.NoInternet -> showError(R.string.internet_is_not_available)
            is ErrorUIState.UnAuthorized -> showError(R.string.unauthorized)
            is ErrorUIState.ConnectionTimeout -> showError(R.string.connection_timeout)
            is ErrorUIState.InternalServerError -> showError(R.string.internal_server_error)
        }
    }

    private fun showError(messageRes: Int) {
        Snackbar.make(
            binding.root,
            getString(messageRes),
            Snackbar.LENGTH_SHORT
        ).show()
    }

}