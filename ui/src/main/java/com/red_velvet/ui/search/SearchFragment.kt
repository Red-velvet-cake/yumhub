package com.red_velvet.ui.search

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import com.red_velvet.mylibrary.R
import com.red_velvet.mylibrary.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment :
    com.red_velvet.ui.base.BaseFragment<FragmentSearchBinding, SearchRecipeUIState, SearchViewModel>(){
    @LayoutRes
    override val layoutIdFragment: Int= R.layout.fragment_search
    override val viewModel: SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val searchAdapter = SearchAdapter(mutableListOf())
        binding.recyclerSearchResult.adapter = searchAdapter
        super.onViewCreated(view, savedInstanceState)
    }
}