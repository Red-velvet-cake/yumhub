package com.red_velvet.yumhub.ui.category

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentCategoryBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeCategoryFragment :
    BaseFragment<FragmentCategoryBinding, RecipeCategoryUiState, RecipeCategoryViewModel>() {

    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_category
    override val viewModel: RecipeCategoryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recipeCategoryAdapter = RecipeCategoryAdapter(emptyList(), viewModel)
        binding.recipeCategoryRecyclerView.adapter = recipeCategoryAdapter
    }
}