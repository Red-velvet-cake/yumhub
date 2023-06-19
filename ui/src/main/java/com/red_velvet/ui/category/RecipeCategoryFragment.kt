package com.red_velvet.ui.category

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import com.red_velvet.mylibrary.R
import com.red_velvet.mylibrary.databinding.FragmentCategoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeCategoryFragment :
    com.red_velvet.ui.base.BaseFragment<FragmentCategoryBinding, CategoryRecipesUiState, CategoryRecipesViewModel>() {

    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_category
    override val viewModel: CategoryRecipesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoryRecipesAdapter = CategoryRecipesAdapter(emptyList(), viewModel)
        binding.recipeCategoryRecyclerView.adapter = categoryRecipesAdapter
    }
}