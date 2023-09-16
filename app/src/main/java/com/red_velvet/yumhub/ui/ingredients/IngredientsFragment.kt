package com.red_velvet.yumhub.ui.ingredients

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentIngredientsBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class IngredientsFragment
    :
    BaseFragment<FragmentIngredientsBinding, IngredientsUIState, IngredientsUIEffect, IngredientsViewModel>() {
    override val layoutIdFragment: Int = R.layout.fragment_ingredients
    override val viewModel: IngredientsViewModel by viewModels()
    override fun observeOnUIEffects() {
//        TODO("Not yet implemented")
    }

    override fun handleUIEffect(uiEffect: IngredientsUIEffect) {
//        TODO("Not yet implemented")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Ingredients"

        val ingredientsAdapter = ExtendedIngredientsAdapter(emptyList(), viewModel)
        binding.recyclerViewExtendedIngredients.adapter = ingredientsAdapter
    }

}