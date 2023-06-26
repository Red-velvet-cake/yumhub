package com.red_velvet.yumhub.ui.mealsSuggester.mealSuggesterStep2


import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentFoodSuggesterStepTwoBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import com.red_velvet.yumhub.ui.mealsSuggester.MealsSuggesterStep1UiEffect
import com.red_velvet.yumhub.ui.mealsSuggester.MealsSuggesterStep1UiState
import com.red_velvet.yumhub.ui.mealsSuggester.MealsSuggesterStep1ViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MealsSuggesterStep2Fragment :
    BaseFragment<FragmentFoodSuggesterStepTwoBinding, MealsSuggesterStep1UiState, MealsSuggesterStep1UiEffect, MealsSuggesterStep1ViewModel>() {
    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_food_suggester_step_two
    override val viewModel: MealsSuggesterStep1ViewModel by viewModels()
    override fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collect { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: MealsSuggesterStep1UiEffect) {
        when (uiEffect) {
            is MealsSuggesterStep1UiEffect.ClickOnGoalSelector -> goalSelector(uiEffect.goal)
            is MealsSuggesterStep1UiEffect.ClickOnActivityLevelSelector -> {}
            is MealsSuggesterStep1UiEffect.ClickOnGenderSelector -> {}
            MealsSuggesterStep1UiEffect.OnNextClicked -> {}
        }
    }

    private fun goalSelector(goal: String) {
        when (goal) {
            "Maintain Weight" -> {
                binding.maintainWeightContainerId.background =
                    resources.getDrawable(R.color.primary)
                binding.maintainWeightTextId.setTextColor(resources.getColor(R.color.white))
                binding.lossWeightContainerId.background = resources.getDrawable(R.color.white)
                binding.lossWeightTextId.setTextColor(resources.getColor(R.color.black))
                binding.gainWeightContainerId.background = resources.getDrawable(R.color.white)
                binding.gainWeightTextId.setTextColor(resources.getColor(R.color.black))
            }
            "Loss Weight"->{
                binding.lossWeightContainerId.background = resources.getDrawable(R.color.primary)
                binding.lossWeightTextId.setTextColor(resources.getColor(R.color.white))
                binding.maintainWeightContainerId.background = resources.getDrawable(R.color.white)
                binding.maintainWeightTextId.setTextColor(resources.getColor(R.color.black))
                binding.gainWeightContainerId.background = resources.getDrawable(R.color.white)
                binding.gainWeightTextId.setTextColor(resources.getColor(R.color.black))
            }
            else->{
                binding.gainWeightContainerId.background = resources.getDrawable(R.color.primary)
                binding.gainWeightTextId.setTextColor(resources.getColor(R.color.white))
                binding.lossWeightContainerId.background = resources.getDrawable(R.color.white)
                binding.lossWeightTextId.setTextColor(resources.getColor(R.color.black))
                binding.maintainWeightContainerId.background = resources.getDrawable(R.color.white)
                binding.maintainWeightTextId.setTextColor(resources.getColor(R.color.black))
            }
        }
    }


}