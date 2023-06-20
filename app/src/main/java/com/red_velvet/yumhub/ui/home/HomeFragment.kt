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
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeUiState, HomeViewModel>() {

    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeOnUIEffects()
    }

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
    }

    private fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collectLatest { handleUIEffect(it) } }
    }

    private fun handleUIEffect(uiEffect: HomeUIEffect) {
        Log.d("alhams", "observeOnUIEffects: $uiEffect")
        when (uiEffect) {
            is HomeUIEffect.ClickOnCategory -> onClickCategory(uiEffect.title)
            is HomeUIEffect.ClickOnRecipe -> onClickRecipe(uiEffect.id)
            is HomeUIEffect.ClickOnSeeAllCategories -> onClickSeeAllCategories()
            is HomeUIEffect.ClickOnSeeAllHealthyRecipes -> onClickSeeAllHealthyRecipes(uiEffect.type)
            is HomeUIEffect.ClickOnSeeAllPopularRecipes -> onClickSeeAllPopularRecipes(uiEffect.type)
            is HomeUIEffect.ClickOnSeeAllQuickRecipes -> onClickSeeAllQuickRecipes(uiEffect.type)
        }
    }

    private fun onClickCategory(categoryTitle: String) {
        val directions =
            HomeFragmentDirections.actionHomeFragmentToCategoryRecipesFragment(categoryTitle, 0)
        findNavController().navigate(directions)
    }

    private fun onClickRecipe(id: Int) {
        val directions = HomeFragmentDirections.actionHomeFragmentToRecipeInformationFragment(id)
        findNavController().navigate(directions)
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