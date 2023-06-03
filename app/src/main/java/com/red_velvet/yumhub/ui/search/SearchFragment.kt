package com.red_velvet.yumhub.ui.search

import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentSearchBinding
import com.red_velvet.yumhub.ui.base.BaseFragment

class SearchFragment :BaseFragment<FragmentSearchBinding,SearchViewModel>(){
    override val layoutIdFragment: Int= R.layout.fragment_search
    override val viewModel: SearchViewModel by viewModels()
}