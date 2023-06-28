package com.red_velvet.yumhub.ui.mealsSuggester.mealsSuggesterStep3

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentFoodSuggesterStepThreeBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import com.red_velvet.yumhub.ui.mealsSuggester.MealsSuggesterStep1UiEffect
import com.red_velvet.yumhub.ui.mealsSuggester.MealsSuggesterStep1UiState
import com.red_velvet.yumhub.ui.mealsSuggester.MealsSuggesterStep1ViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MealsSuggesterStep3Fragment :
    BaseFragment<FragmentFoodSuggesterStepThreeBinding, MealsSuggesterStep1UiState, MealsSuggesterStep1UiEffect, MealsSuggesterStep1ViewModel>() {
    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_food_suggester_step_three
    override val viewModel: MealsSuggesterStep1ViewModel by activityViewModels()
    override fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collect { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: MealsSuggesterStep1UiEffect) {
        when (uiEffect) {
            is MealsSuggesterStep1UiEffect.ClickOnGoalSelector -> {}
            is MealsSuggesterStep1UiEffect.ClickOnActivityLevelSelector -> {}
            is MealsSuggesterStep1UiEffect.ClickOnGenderSelector -> {}
            is MealsSuggesterStep1UiEffect.OnNextClicked -> {}
            MealsSuggesterStep1UiEffect.OnEmptyFields -> {}
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i("jalal","step3 created")
        val mealSuggesterAdapter = MealSuggesterAdapter(mutableListOf(), viewModel)
        binding.suggestedMealsRecyclerView.adapter = mealSuggesterAdapter

    }

}