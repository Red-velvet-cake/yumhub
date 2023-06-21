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
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment :BaseFragment<FragmentSearchBinding,SearchRecipeUIState,SearchViewModel>(){
    @LayoutRes
    override val layoutIdFragment: Int= R.layout.fragment_search
    override val viewModel: SearchViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        observeOnUIEffects()
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val searchAdapter = SearchAdapter(mutableListOf(),viewModel)
        binding.recyclerSearchResult.adapter = searchAdapter
        super.onViewCreated(view, savedInstanceState)
    }
    private fun observeOnUIEffects() {
        lifecycleScope.launch {
            when (val effect = viewModel.effect.first()) {
                is SearchUIEffect.ClickOnRecipe -> onClickRecipe(effect.recipeId)
            }
        }
    }
    private fun onClickRecipe(recipeId: Int) {
        val directions =
            SearchFragmentDirections.actionSearchFragmentToRecipeInformationFragment(recipeId)
        findNavController().navigate(directions)
    }
}