package com.red_velvet.yumhub.ui.mealsSuggester.mealSuggesterStep1

import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentFoodSuggesterStepOneBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import com.red_velvet.yumhub.ui.mealsSuggester.MealsSuggesterStep1UiEffect
import com.red_velvet.yumhub.ui.mealsSuggester.MealsSuggesterStep1UiState
import com.red_velvet.yumhub.ui.mealsSuggester.MealsSuggesterStep1ViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MealsSuggesterStep1Fragment :
    BaseFragment<FragmentFoodSuggesterStepOneBinding, MealsSuggesterStep1UiState, MealsSuggesterStep1UiEffect, MealsSuggesterStep1ViewModel>() {
    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_food_suggester_step_one
    override val viewModel: MealsSuggesterStep1ViewModel by viewModels()
    override fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collectLatest { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: MealsSuggesterStep1UiEffect) {
        when (uiEffect) {
            is MealsSuggesterStep1UiEffect.ClickOnGenderSelector -> genderSelector(uiEffect.gender)
            is MealsSuggesterStep1UiEffect.ClickOnActivityLevelSelector -> activityLevelSelector(
                uiEffect.activityLevel
            )

            MealsSuggesterStep1UiEffect.OnNextClicked -> onNextButtonClicked()
            is MealsSuggesterStep1UiEffect.ClickOnGoalSelector -> {}
        }
    }

    private fun onNextButtonClicked() {
//        val directions =
//            MealsSuggesterStep1FragmentDirections.actionMealsSuggesterStep1FragmentToMealsSuggesterStep2Fragment()
//        findNavController().navigate(directions)
    }

    private fun activityLevelSelector(activityLevel: String) {
        when(activityLevel)
        {
            "Lazy"->{
                binding.lazy.background = resources.getDrawable(R.color.primary)
                binding.lazy.setTextColor(resources.getColor(R.color.white))
                binding.lazy.compoundDrawableTintList=resources.getColorStateList(R.color.white)
                binding.Normal.background = resources.getDrawable(R.color.white)
                binding.Normal.setTextColor(resources.getColor(R.color.black))
                binding.Normal.compoundDrawableTintList=resources.getColorStateList(R.color.black)
                binding.VeryActive.background = resources.getDrawable(R.color.white)
                binding.VeryActive.setTextColor(resources.getColor(R.color.black))
                binding.VeryActive.compoundDrawableTintList=resources.getColorStateList(R.color.black)
            }
            "Normal"->{
                binding.Normal.background = resources.getDrawable(R.color.primary)
                binding.Normal.setTextColor(resources.getColor(R.color.white))
                binding.Normal.compoundDrawableTintList=resources.getColorStateList(R.color.white)
                binding.lazy.background = resources.getDrawable(R.color.white)
                binding.lazy.setTextColor(resources.getColor(R.color.black))
                binding.lazy.compoundDrawableTintList=resources.getColorStateList(R.color.black)
                binding.VeryActive.background = resources.getDrawable(R.color.white)
                binding.VeryActive.setTextColor(resources.getColor(R.color.black))
                binding.VeryActive.compoundDrawableTintList=resources.getColorStateList(R.color.black)
            }
            else->{
                binding.VeryActive.background = resources.getDrawable(R.color.primary)
                binding.VeryActive.setTextColor(resources.getColor(R.color.white))
                binding.VeryActive.compoundDrawableTintList=resources.getColorStateList(R.color.white)
                binding.Normal.background = resources.getDrawable(R.color.white)
                binding.Normal.setTextColor(resources.getColor(R.color.black))
                binding.Normal.compoundDrawableTintList=resources.getColorStateList(R.color.black)
                binding.lazy.background = resources.getDrawable(R.color.white)
                binding.lazy.setTextColor(resources.getColor(R.color.black))
                binding.lazy.compoundDrawableTintList=resources.getColorStateList(R.color.black)

            }
        }
    }

    private fun genderSelector(gender: String) {
        if (gender == "Male")
        {
            binding.maleContainerId.background = resources.getDrawable(R.color.primary)
            binding.femaleContainerId.background = resources.getDrawable(R.color.white)
            binding.maleTextId.setTextColor(resources.getColor(R.color.white))
            binding.femaleTextId.setTextColor(resources.getColor(R.color.black))
            binding.femaleTextId.compoundDrawableTintList=resources.getColorStateList(R.color.primary)
            binding.maleTextId.compoundDrawableTintList=resources.getColorStateList(R.color.white)
        }
        else
        {
            binding.femaleContainerId.background = resources.getDrawable(R.color.primary)
            binding.maleContainerId.background = resources.getDrawable(R.color.white)
            binding.femaleTextId.setTextColor(resources.getColor(R.color.white))
            binding.maleTextId.setTextColor(resources.getColor(R.color.black))
            binding.maleTextId.compoundDrawableTintList=resources.getColorStateList(R.color.primary)
            binding.femaleTextId.compoundDrawableTintList=resources.getColorStateList(R.color.white)
        }

    }
}