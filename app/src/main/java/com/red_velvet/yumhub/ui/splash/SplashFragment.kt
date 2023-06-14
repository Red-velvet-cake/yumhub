package com.red_velvet.yumhub.ui.splash

import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentSearchBinding
import com.red_velvet.yumhub.databinding.FragmentSplashBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.search.SearchRecipeUIState
import com.red_velvet.yumhub.ui.search.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment :BaseFragment<FragmentSplashBinding, SplashUIState, SplashViewModel>() {
    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_splash
    override val viewModel: SplashViewModel by viewModels()
}