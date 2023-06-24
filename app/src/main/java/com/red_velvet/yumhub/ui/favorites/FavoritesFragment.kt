package com.red_velvet.yumhub.ui.favorites

import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentFavoriteBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment :
    BaseFragment<FragmentFavoriteBinding, FavoritesUiState, FavoritesUiEffect, FavoritesViewModel>() {
    override val layoutIdFragment = R.layout.fragment_favorites
    override val viewModel: FavoritesViewModel by viewModels()

    override fun observeOnUIEffects() {
        TODO("Not yet implemented")
    }

    override fun handleUIEffect(uiEffect: FavoritesUiEffect) {
        TODO("Not yet implemented")
    }

}