package com.red_velvet.yumhub.ui.category

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentCategoryRecipesBinding
import com.red_velvet.yumhub.ui.base.BaseFragment

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryRecipesFragment :
    BaseFragment<FragmentCategoryRecipesBinding, CategoryRecipesUiState, CategoryRecipesViewModel>() {

    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_category_recipes
    override val viewModel: CategoryRecipesViewModel by viewModels()
    private val args: CategoryRecipesFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoryRecipesAdapter = CategoryRecipesAdapter(emptyList(), viewModel)
        binding.recipeCategoryRecyclerView.adapter = categoryRecipesAdapter

        val type = args.categoryTitle
        if (type != null) {
            viewModel.getRecipesByCategoryTitle(type, getRecipesType(args.type))
        } else {
            viewModel.getRecipesByCategoryTitle(null, getRecipesType(args.type))
        }

    }

    private fun getRecipesType(type: Int): String {
        return when (type) {
            0 -> "healthiness"
            1 -> "popular"
            2 -> "quick"
            else -> ""
        }
    }
}