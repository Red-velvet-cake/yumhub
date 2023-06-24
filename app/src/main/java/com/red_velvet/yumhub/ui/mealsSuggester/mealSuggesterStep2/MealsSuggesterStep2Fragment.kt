package com.red_velvet.yumhub.ui.mealsSuggester.mealSuggesterStep1

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentFoodSuggesterStepOneBinding
import com.red_velvet.yumhub.databinding.FragmentFoodSuggesterStepTwoBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import com.red_velvet.yumhub.ui.mealsSuggester.mealSuggesterStep2.MealsSuggesterStep2UiEffect
import com.red_velvet.yumhub.ui.mealsSuggester.mealSuggesterStep2.MealsSuggesterStep2ViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MealsSuggesterStep2Fragment:BaseFragment<FragmentFoodSuggesterStepTwoBinding, MealsSuggesterStep2UiState, MealsSuggesterStep2ViewModel>() {
    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_food_suggester_step_two
    override val viewModel: MealsSuggesterStep2ViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        observeOnUiEffect()
    }

    private fun observeOnUiEffect() {
        lifecycleScope.launch {
            val effect = viewModel.effect.collect{
                when(it)
                {
                    is MealsSuggesterStep2UiEffect.ClickOnGoalSelector -> goalSelector(it.goal)
                }
            }

        }
    }

    private fun goalSelector(goal: String) {
        when(goal)
        {
            "Maintain Weight"->{
                binding.maintainWeightContainerId.background = resources.getDrawable(R.color.primary)
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