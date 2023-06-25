package com.red_velvet.yumhub.ui.profile

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentProfileBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment :
    BaseFragment<FragmentProfileBinding, ProfileUiState, ProfileUiEffect, ProfileViewModel>() {
    override val layoutIdFragment = R.layout.fragment_profile
    override val viewModel: ProfileViewModel by viewModels()

    override fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collectLatest { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: ProfileUiEffect) {
        when (uiEffect) {
            is ProfileUiEffect.ClickOnPersonalInfo -> navigateToPersonalInfoScreen()
            is ProfileUiEffect.ClickOnChatBot -> navigateToChatBotScreen()
            is ProfileUiEffect.ClickOnFavorites -> navigateToFavoritesScreen()
            is ProfileUiEffect.ClickOnReviewFood -> navigateToReviewFoodScreen()
            is ProfileUiEffect.ClickOnNutritionalValue -> navigateToNutritionalScreen()
            is ProfileUiEffect.ClickOnFoodSuggester -> navigateToFoodSuggesterScreen()
        }
    }

    private fun navigateToPersonalInfoScreen() {}

    private fun navigateToChatBotScreen() {}

    private fun navigateToFavoritesScreen() {}

    private fun navigateToReviewFoodScreen() {}

    private fun navigateToNutritionalScreen() {}

    private fun navigateToFoodSuggesterScreen() {}

}