package com.red_velvet.yumhub.ui.mealsSuggester.mealsSuggesterStep3

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentFoodSuggesterStepThreeBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import com.red_velvet.yumhub.ui.mealsSuggester.MealsSuggesterStep1UiState
import com.red_velvet.yumhub.ui.mealsSuggester.MealsSuggesterStep1ViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MealsSuggesterStep3Fragment:BaseFragment<FragmentFoodSuggesterStepThreeBinding, MealsSuggesterStep1UiState, MealsSuggesterStep1ViewModel>() {
    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_food_suggester_step_three
    override val viewModel: MealsSuggesterStep1ViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        observeOnUiEffect()
        val mealSuggesterAdapter = MealSuggesterAdapter(mutableListOf(),viewModel)
        binding.suggestedMealsRecyclerView.adapter = mealSuggesterAdapter
    }

    private fun observeOnUiEffect() {
        lifecycleScope.launch {
            val effect = viewModel.effectStepThree.collect{
                when(it)
                {
                    is MealsSuggesterStep3UiEffect.ClickOnGoalSelector -> Log.i("jalal","do what you want")
                }
            }

        }
    }

}