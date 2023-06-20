package com.red_velvet.yumhub.ui.recipeDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentRecipeInformationBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeInformationFragment : BaseFragment<
        FragmentRecipeInformationBinding,
        RecipeInformationUIState,
        RecipeInformationViewModel>() {
    override val layoutIdFragment: Int = R.layout.fragment_recipe_information
    override val viewModel: RecipeInformationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dishTypesAdapter = DishTypesAdapter(emptyList(), viewModel)
        binding.recyclerViewDishType.adapter = dishTypesAdapter

        val ingredientsAdapter = IngredientsAdapter(emptyList(), viewModel)
        binding.recyclerViewIngredients.adapter = ingredientsAdapter
    }
}