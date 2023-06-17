package com.red_velvet.yumhub.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentHomeBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import com.red_velvet.yumhub.ui.home.adapters.HealthyRecipeAdapter
import com.red_velvet.yumhub.ui.home.adapters.PopularRecipeAdapter
import com.red_velvet.yumhub.ui.home.adapters.QuickRecipeAdapter
import com.red_velvet.yumhub.ui.home.adapters.RecipesCategoriesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeUiState, HomeViewModel>() {

    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesRecipeAdapter = RecipesCategoriesAdapter(emptyList(), viewModel)
        val popularRecipeAdapter = PopularRecipeAdapter(emptyList(), viewModel)
        val healthyRecipeAdapter = HealthyRecipeAdapter(emptyList(), viewModel)
        val quickRecipeAdapter = QuickRecipeAdapter(emptyList(), viewModel)

        binding.apply {
            categoryRecyclerView.adapter = categoriesRecipeAdapter
            popularRecyclerView.adapter = popularRecipeAdapter
            healthyRecyclerView.adapter = healthyRecipeAdapter
            quickRecyclerView.adapter = quickRecipeAdapter
        }
        observeOnUIEffects()
    }

    private fun observeOnUIEffects() {
        lifecycleScope.launch {
            val effect = viewModel.effect.first()
            Log.d("alhams", "observeOnUIEffects: $effect")
            when (effect) {
                is HomeUIEffect.ClickOnCategory -> onClickCategory(effect.title)
                is HomeUIEffect.ClickOnHealthyRecipe -> onClickHealthyRecipe(effect.id)
                is HomeUIEffect.ClickOnPopularRecipe -> onClickPopularRecipe(effect.id)
                is HomeUIEffect.ClickOnQuickRecipe -> onClickQuickRecipe(effect.id)
                HomeUIEffect.ClickOnSeeAllCategories -> onClickSeeAllCategories()
                is HomeUIEffect.ClickOnSeeAllHealthyRecipes -> onClickSeeAllHealthyRecipes(effect.type)
                is HomeUIEffect.ClickOnSeeAllPopularRecipes -> onClickSeeAllPopularRecipes(effect.type)
                is HomeUIEffect.ClickOnSeeAllQuickRecipes -> onClickSeeAllQuickRecipes(effect.type)
            }
        }
    }

    private fun onClickCategory(categoryTitle: String) {
        val directions =
            HomeFragmentDirections.actionHomeFragmentToCategoryRecipesFragment(categoryTitle, 0)
        findNavController().navigate(directions)
    }

    private fun onClickHealthyRecipe(id: Int) {

    }

    private fun onClickPopularRecipe(id: Int) {

    }

    private fun onClickQuickRecipe(id: Int) {

    }

    private fun onClickSeeAllPopularRecipes(type: Int) {
        val directions =
            HomeFragmentDirections.actionHomeFragmentToCategoryRecipesFragment(null, type)
        findNavController().navigate(directions)
    }

    private fun onClickSeeAllHealthyRecipes(type: Int) {
        val directions =
            HomeFragmentDirections.actionHomeFragmentToCategoryRecipesFragment(null, type)
        findNavController().navigate(directions)
    }

    private fun onClickSeeAllQuickRecipes(type: Int) {
        val directions =
            HomeFragmentDirections.actionHomeFragmentToCategoryRecipesFragment(null, type)
        findNavController().navigate(directions)
    }

    private fun onClickSeeAllCategories() {
        val directions =
            HomeFragmentDirections.actionHomeFragmentToRecipeCategoriesFragment()
        findNavController().navigate(directions)
    }

}