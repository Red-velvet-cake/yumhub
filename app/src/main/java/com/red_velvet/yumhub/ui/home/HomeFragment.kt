package com.red_velvet.yumhub.ui.home

import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentHomeBinding
import com.red_velvet.yumhub.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()

}