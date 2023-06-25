package com.red_velvet.yumhub.ui.ingredients

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentIngredientsBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IngredientsFragment
    : BaseFragment<FragmentIngredientsBinding, IngredientsUIState, IngredientsViewModel>() {
    override val layoutIdFragment: Int = R.layout.fragment_ingredients
    override val viewModel: IngredientsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ingredientsAdapter = ExtendedIngredientsAdapter(emptyList(), viewModel)
        binding.recyclerViewExtendedIngredients.adapter = ingredientsAdapter
    }

}