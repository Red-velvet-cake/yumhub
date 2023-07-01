package com.red_velvet.yumhub.ui.mealsSuggester.mealSuggesterStep1

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
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
    override val viewModel: MealsSuggesterStep1ViewModel by activityViewModels()
    override fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collectLatest { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: MealsSuggesterStep1UiEffect) {
        when (uiEffect) {
            is MealsSuggesterStep1UiEffect.ClickOnGenderSelector -> genderSelector(uiEffect.gender)
            is MealsSuggesterStep1UiEffect.ClickOnActivityLevelSelector -> activityLevelSelector(
                uiEffect.activityLevel
            )

            is MealsSuggesterStep1UiEffect.ClickOnGoalSelector -> {}
            is MealsSuggesterStep1UiEffect.OnNextClicked -> onNextButtonClicked(uiEffect.type)
            MealsSuggesterStep1UiEffect.OnEmptyFields -> {}
            is MealsSuggesterStep1UiEffect.OnSelectItemRecipe -> {}
        }
    }

    private fun onNextButtonClicked(type:String ) {
        if (type == "stepOne") {
            val directions =
                MealsSuggesterStep1FragmentDirections.actionMealsSuggesterStep1FragmentToMealsSuggesterStep2Fragment()
            findNavController().navigate(directions)
        }
    }

    private fun activityLevelSelector(activityLevel: Int) {
        when(activityLevel)
        {
            1->{
                binding.lazy.apply {
                    background = ContextCompat.getDrawable(context,R.color.primary)
                    setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                    compoundDrawableTintList= ContextCompat.getColorStateList(context,R.color.white)
                }
                binding.Normal.apply {
                    background = ContextCompat.getDrawable(context,R.color.white)
                    setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                    compoundDrawableTintList= ContextCompat.getColorStateList(context,R.color.black)
                }
                binding.VeryActive.apply {
                    background = ContextCompat.getDrawable(context,R.color.white)
                    setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                    compoundDrawableTintList= ContextCompat.getColorStateList(context,R.color.black)
                }
            }

            2->{
                binding.Normal.apply {
                    background = ContextCompat.getDrawable(context,R.color.primary)
                    setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                    compoundDrawableTintList= ContextCompat.getColorStateList(context,R.color.white)
                }
                binding.lazy.apply {
                    background = ContextCompat.getDrawable(context,R.color.white)
                    setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                    compoundDrawableTintList= ContextCompat.getColorStateList(context,R.color.black)
                }
                binding.VeryActive.apply {
                    background = ContextCompat.getDrawable(context,R.color.white)
                    setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                    compoundDrawableTintList= ContextCompat.getColorStateList(context,R.color.black)
                }
            }

            else->{
                binding.VeryActive.apply {
                     background = ContextCompat.getDrawable(context,R.color.primary)
                    setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                    compoundDrawableTintList= ContextCompat.getColorStateList(context,R.color.white)
                }
                binding.Normal.apply {
                     background = ContextCompat.getDrawable(context,R.color.white)
                    setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                    compoundDrawableTintList= ContextCompat.getColorStateList(context,R.color.black)
                }
                binding.lazy.apply {
                     background = ContextCompat.getDrawable(context,R.color.white)
                    setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                    compoundDrawableTintList= ContextCompat.getColorStateList(context,R.color.black)
                }
            }
        }
    }

    private fun genderSelector(gender: String) {
        if (gender == "Male")
        {
            binding.apply {
                maleContainerId.background = ContextCompat.getDrawable(requireContext(),R.color.primary)
                femaleContainerId.background = ContextCompat.getDrawable(requireContext(),R.color.white)
                maleTextId.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                femaleTextId.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                femaleTextId.compoundDrawableTintList= ContextCompat.getColorStateList(requireContext(),R.color.primary)
                maleTextId.compoundDrawableTintList= ContextCompat.getColorStateList(requireContext(),R.color.white)
            }
        }
        else
        {
            binding.apply {
                femaleContainerId.background = ContextCompat.getDrawable(requireContext(),R.color.primary)
                maleContainerId.background = ContextCompat.getDrawable(requireContext(),R.color.white)
                femaleTextId.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                maleTextId.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                maleTextId.compoundDrawableTintList= ContextCompat.getColorStateList(requireContext(),R.color.primary)
                femaleTextId.compoundDrawableTintList= ContextCompat.getColorStateList(requireContext(),R.color.white)
            }
        }

    }
}