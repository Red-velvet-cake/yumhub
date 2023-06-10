package com.red_velvet.yumhub.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentSearchBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment :BaseFragment<FragmentSearchBinding>(){
    @LayoutRes
    override val layoutIdFragment: Int= R.layout.fragment_search
    override val viewModel: SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val searchAdapter = SearchAdapter(mutableListOf())
        binding.recyclerSearchResult.adapter = searchAdapter
        super.onViewCreated(view, savedInstanceState)
    }
}