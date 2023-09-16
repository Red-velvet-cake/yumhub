package com.red_velvet.yumhub.ui.profile

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentProfileBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import com.red_velvet.yumhub.ui.chatbot.ChatbotFragment
import com.red_velvet.yumhub.ui.search.SearchFragmentDirections
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
            is ProfileUiEffect.ClickOnSettings -> navigateToPersonalInfoScreen()
            is ProfileUiEffect.ClickOnChatBot -> navigateToChatBotScreen()
            is ProfileUiEffect.ClickOnFavorites -> navigateToFavoritesScreen()
            is ProfileUiEffect.ClickOnHistory -> navigateToHistoryScreen()
            is ProfileUiEffect.ClickOnNutritionalValue -> navigateToNutritionalScreen()
            is ProfileUiEffect.ClickOnFoodSuggester -> navigateToFoodSuggesterScreen()
            is ProfileUiEffect.ClickOnMealTest -> navigateToMealTestScreen()
        }
    }

    private fun navigateToPersonalInfoScreen() {}

    private fun navigateToChatBotScreen() {
        val directions =
            ProfileFragmentDirections.actionProfileFragmentToChatbotFragment()
        findNavController().navigate(directions)
    }

    private fun navigateToFavoritesScreen() {
        val action = ProfileFragmentDirections.actionProfileFragmentToFavoritesFragment()
        findNavController().navigate(action)
    }
    
    private fun navigateToHistoryScreen() {
        val directions = ProfileFragmentDirections.actionProfileFragmentToHistoryFragment()
        findNavController().navigate(directions)
    }

    private fun navigateToNutritionalScreen() {
        val action = ProfileFragmentDirections.actionProfileFragmentToNutritionalValueFragment()
        findNavController().navigate(action)
    }

    private fun navigateToFoodSuggesterScreen() {
        val directions =
            ProfileFragmentDirections.actionProfileFragmentToMealsSuggesterStep1Fragment()
        findNavController().navigate(directions)
    }

    private fun navigateToMealTestScreen() {}

}