package com.red_velvet.yumhub.ui.recipeDetails

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentRecipeInformationBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecipeInformationFragment : BaseFragment<
        FragmentRecipeInformationBinding,
        RecipeInformationUIState,
        RecipeDetailsUIEffect,
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

    override fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collectLatest { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: RecipeDetailsUIEffect) {
        when (uiEffect) {
            is RecipeDetailsUIEffect.ClickOnDishType -> onDishTypeClicked(uiEffect.type)
            is RecipeDetailsUIEffect.ClickOnGoToCookingSteps -> onShowRecipeCookingStepsClicked(
                uiEffect.recipeId
            )

            is RecipeDetailsUIEffect.ClickAddToMealPlan -> onClickAddToMealPlan(uiEffect.recipeId)
        }
    }

    private fun onClickAddToMealPlan(recipeId: Int) {
        val directions = RecipeInformationFragmentDirections
            .actionRecipeInformationFragmentToAddToMealPlanFragment(recipeId)

        findNavController().navigate(directions)
    }

    private fun onShowRecipeCookingStepsClicked(recipeId: Int) {
        val directions = RecipeInformationFragmentDirections
            .actionRecipeInformationFragmentToInstructionsFragment(recipeId)

        findNavController().navigate(directions)
    }

    private fun onDishTypeClicked(type: String) {
        val directions = RecipeInformationFragmentDirections
            .actionRecipeInformationFragmentToCategoryRecipesFragment(type, 0)

        findNavController().navigate(directions)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        val inflater = MenuInflater(context)
        inflater.inflate(R.menu.menu_favorite, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return super.onContextItemSelected(item)
    }

}