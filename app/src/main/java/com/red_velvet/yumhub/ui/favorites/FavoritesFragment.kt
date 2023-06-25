package com.red_velvet.yumhub.ui.favorites

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentFavoritesBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoritesFragment :
    BaseFragment<FragmentFavoritesBinding, FavoritesUiState, FavoritesUiEffect, FavoritesViewModel>() {
    override val layoutIdFragment = R.layout.fragment_favorites
    override val viewModel: FavoritesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val favoriteRecipesAdapter = FavoriteRecipesAdapter(mutableListOf(), viewModel)
        binding.favoritesRecycler.adapter = favoriteRecipesAdapter

        val itemTouchHelper = ItemTouchHelper(SwipeToDeleteCallback(favoriteRecipesAdapter))
        itemTouchHelper.attachToRecyclerView(binding.favoritesRecycler)
    }

    override fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collect { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: FavoritesUiEffect) {
        when (uiEffect) {
            is FavoritesUiEffect.ClickOnRecipe -> navigateToRecipeDetails(uiEffect.id)
        }
    }

    private fun navigateToRecipeDetails(id: Int) {
        val action =
            FavoritesFragmentDirections.actionFavoritesFragmentToRecipeInformationFragment(id)
        findNavController().navigate(action)
    }

}