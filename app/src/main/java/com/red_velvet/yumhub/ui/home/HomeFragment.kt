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
            categoryListener = viewModel
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
                HomeUIEffect.ClickOnSeeAllHealthyRecipes -> onClickSeeAllHealthyRecipes()
                HomeUIEffect.ClickOnSeeAllPopularRecipes -> onClickSeeAllPopularRecipes()
                HomeUIEffect.ClickOnSeeAllQuickRecipes -> onClickSeeAllQuickRecipes()
            }
        }
    }

    private fun onClickCategory(categoryTitle: String) {
        val directions =
            HomeFragmentDirections.actionHomeFragmentToCategoryRecipesFragment(categoryTitle)
        findNavController().navigate(directions)
    }

    private fun onClickHealthyRecipe(id: Int) {

    }

    private fun onClickPopularRecipe(id: Int) {

    }

    private fun onClickQuickRecipe(id: Int) {

    }

    private fun onClickSeeAllPopularRecipes() {

    }

    private fun onClickSeeAllHealthyRecipes() {

    }

    private fun onClickSeeAllQuickRecipes() {

    }

    private fun onClickSeeAllCategories() {
        val directions =
            HomeFragmentDirections.actionHomeFragmentToRecipeCategoriesFragment()
        findNavController().navigate(directions)
    }

}