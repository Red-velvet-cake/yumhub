package com.red_velvet.yumhub.ui.mealsSuggester.mealSuggesterStep2


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentFoodSuggesterStepTwoBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import com.red_velvet.yumhub.ui.mealsSuggester.MealsSuggesterStep1UiEffect
import com.red_velvet.yumhub.ui.mealsSuggester.MealsSuggesterStep1UiState
import com.red_velvet.yumhub.ui.mealsSuggester.MealsSuggesterStep1ViewModel
import com.red_velvet.yumhub.ui.mealsSuggester.mealSuggesterStep1.MealsSuggesterStep1FragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MealsSuggesterStep2Fragment :
    BaseFragment<FragmentFoodSuggesterStepTwoBinding, MealsSuggesterStep1UiState, MealsSuggesterStep1UiEffect, MealsSuggesterStep1ViewModel>() {
    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_food_suggester_step_two
    override val viewModel: MealsSuggesterStep1ViewModel by activityViewModels()
    override fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collect { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: MealsSuggesterStep1UiEffect) {
        when (uiEffect) {
            is MealsSuggesterStep1UiEffect.ClickOnGoalSelector -> goalSelector(uiEffect.goal)
            is MealsSuggesterStep1UiEffect.ClickOnActivityLevelSelector -> {}
            is MealsSuggesterStep1UiEffect.ClickOnGenderSelector -> {}
            is MealsSuggesterStep1UiEffect.OnNextClicked -> onNextButtonClicked(uiEffect.type)
            MealsSuggesterStep1UiEffect.OnEmptyFields -> onEmptyFields()
            is MealsSuggesterStep1UiEffect.OnSelectItemRecipe -> {}
        }
    }

    private fun onEmptyFields() {
        Toast.makeText(this.context,"fill in all fields",Toast.LENGTH_LONG).show()
    }

    private fun goalSelector(goal: String) {
        when (goal) {
            MAINTAIN_WEIGHT -> {
                binding.maintainWeightContainerId.background = ContextCompat.getDrawable(requireContext(),R.color.primary)
                binding.maintainWeightTextId.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                binding.lossWeightContainerId.background = ContextCompat.getDrawable(requireContext(),R.color.white)
                binding.lossWeightTextId.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                binding.gainWeightContainerId.background = ContextCompat.getDrawable(requireContext(),R.color.white)
                binding.gainWeightTextId.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            }
            LOSS_WEIGHT->{
                binding.lossWeightContainerId.background = ContextCompat.getDrawable(requireContext(),R.color.primary)
                binding.lossWeightTextId.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                binding.maintainWeightContainerId.background = ContextCompat.getDrawable(requireContext(),R.color.white)
                binding.maintainWeightTextId.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                binding.gainWeightContainerId.background = ContextCompat.getDrawable(requireContext(),R.color.white)
                binding.gainWeightTextId.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            }
            else->{
                binding.gainWeightContainerId.background = ContextCompat.getDrawable(requireContext(),R.color.primary)
                binding.gainWeightTextId.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                binding.lossWeightContainerId.background = ContextCompat.getDrawable(requireContext(),R.color.white)
                binding.lossWeightTextId.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                binding.maintainWeightContainerId.background = ContextCompat.getDrawable(requireContext(),R.color.white)
                binding.maintainWeightTextId.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            }
        }
    }
    private fun onNextButtonClicked(type: String) {
        if (type == "stepTwo") {
            val directions =
                MealsSuggesterStep2FragmentDirections.actionMealsSuggesterStep2FragmentToMealsSuggesterStep3Fragment()
            findNavController().navigate(directions)
        }
    }
    companion object{
        const val LOSS_WEIGHT = "Loss Weight"
        const val MAINTAIN_WEIGHT= "Maintain Weight"
    }
}