package com.red_velvet.ui.signUp


import androidx.fragment.app.viewModels
import com.red_velvet.mylibrary.R
import com.red_velvet.mylibrary.databinding.FragmentSignUpBinding
import com.red_velvet.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SignUpFragment : BaseFragment<FragmentSignUpBinding, SignUpUIState, SignUpViewModel>() {
    override val layoutIdFragment = R.layout.fragment_sign_up
    override val viewModel: SignUpViewModel by viewModels()
}