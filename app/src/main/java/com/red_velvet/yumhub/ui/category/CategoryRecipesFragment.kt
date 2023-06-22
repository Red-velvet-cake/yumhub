package com.red_velvet.yumhub.ui.category

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentCategoryRecipesBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoryRecipesFragment : BaseFragment<
        FragmentCategoryRecipesBinding,
        CategoryRecipesUiState,
        CategoryRecipesUIEffect,
        CategoryRecipesViewModel>() {

    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_category_recipes
    override val viewModel: CategoryRecipesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoryRecipesAdapter = CategoryRecipesAdapter(emptyList(), viewModel)
        binding.recipeCategoryRecyclerView.adapter = categoryRecipesAdapter
    }

    override fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collectLatest { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: CategoryRecipesUIEffect) {
        Log.d("alhams", "observeOnUIEffects: $uiEffect")
        when (uiEffect) {
            is CategoryRecipesUIEffect.ClickOnRecipe -> onClickRecipe(uiEffect.id)
        }
    }

    private fun onClickRecipe(id: Int) {
        val directions =
            CategoryRecipesFragmentDirections.actionCategoryRecipesFragmentToRecipeInformationFragment(
                id
            )
        findNavController().navigate(directions)
    }
}