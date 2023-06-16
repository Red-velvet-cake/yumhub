package com.red_velvet.yumhub.ui.recipecategories


import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentRecipeCategoriesBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeCategoriesFragment :
    BaseFragment<FragmentRecipeCategoriesBinding, RecipeCategoriesUiState, RecipeCategoriesViewModel>() {

    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_recipe_categories
    override val viewModel: RecipeCategoriesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesRecipeAdapter = RecipeCategoriesAdapter(emptyList())
        binding.recipeCategoriesRecyclerView.adapter = categoriesRecipeAdapter

    }

}