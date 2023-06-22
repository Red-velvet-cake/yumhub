package com.red_velvet.yumhub.ui.recipecategories


import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentRecipeCategoriesBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecipeCategoriesFragment :
    BaseFragment<FragmentRecipeCategoriesBinding, RecipeCategoriesUiState, RecipeCategoriesUIEffect, RecipeCategoriesViewModel>() {

    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_recipe_categories
    override val viewModel: RecipeCategoriesViewModel by viewModels()
    override fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collectLatest { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: RecipeCategoriesUIEffect) {
        when (uiEffect) {
            is RecipeCategoriesUIEffect.ClickOnCategory -> onCategoryClicked(uiEffect.categoryType)
        }
    }

    private fun onCategoryClicked(categoryType: String) {
        val directions = RecipeCategoriesFragmentDirections
            .actionRecipeCategoriesFragmentToCategoryRecipesFragment(categoryType, 0)

        findNavController().navigate(directions)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesRecipeAdapter = RecipeCategoriesAdapter(emptyList(), viewModel)
        binding.recipeCategoriesRecyclerView.adapter = categoriesRecipeAdapter

    }

}