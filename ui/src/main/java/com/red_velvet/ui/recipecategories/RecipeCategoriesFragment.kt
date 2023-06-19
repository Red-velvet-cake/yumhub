package com.red_velvet.ui.recipecategories


import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import com.red_velvet.mylibrary.R
import com.red_velvet.mylibrary.databinding.FragmentRecipeCategoriesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeCategoriesFragment :
    com.red_velvet.ui.base.BaseFragment<FragmentRecipeCategoriesBinding, RecipeCategoriesUiState, RecipeCategoriesViewModel>() {

    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_recipe_categories
    override val viewModel: RecipeCategoriesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesRecipeAdapter = RecipeCategoriesAdapter(emptyList())
        binding.recipeCategoriesRecyclerView.adapter = categoriesRecipeAdapter

    }

}