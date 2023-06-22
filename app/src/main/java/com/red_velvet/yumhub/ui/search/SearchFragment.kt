package com.red_velvet.yumhub.ui.search

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentSearchBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment :
    BaseFragment<FragmentSearchBinding, SearchRecipeUIState, SearchUIEffect, SearchViewModel>() {
    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_search
    override val viewModel: SearchViewModel by viewModels()
    override fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collectLatest { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: SearchUIEffect) {
        when (uiEffect) {
            is SearchUIEffect.ClickOnRecipe -> onRecipeClicked(uiEffect.recipeId)
        }
    }

    private fun onRecipeClicked(recipeId: Int) {
        val directions =
            SearchFragmentDirections.actionSearchFragmentToRecipeInformationFragment(recipeId)

        findNavController().navigate(directions)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val searchAdapter = SearchAdapter(mutableListOf(), viewModel)
        binding.recyclerSearchResult.adapter = searchAdapter
        super.onViewCreated(view, savedInstanceState)
    }
}