package com.red_velvet.yumhub.ui.signUp


import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentSignUpBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SignUpFragment: BaseFragment<FragmentSignUpBinding>(){
    @LayoutRes
    override val layoutIdFragment = R.layout.fragment_sign_up
    override val viewModel: SignUpViewModel by viewModels()

}