package com.red_velvet.yumhub.ui.deit

import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentDeitBinding
import com.red_velvet.yumhub.databinding.FragmentSearchBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import com.red_velvet.yumhub.ui.search.SearchRecipeUIState
import com.red_velvet.yumhub.ui.search.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DietFragment  : BaseFragment<FragmentDeitBinding, DietUIState, DietViewModel>(){
    @LayoutRes
    override val layoutIdFragment: Int= R.layout.fragment_deit
    override val viewModel: DietViewModel by viewModels()
}