package com.red_velvet.yumhub.ui.mealsSuggester

import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentFoodSuggesterStepOneBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealsSuggesterFragment:BaseFragment<FragmentFoodSuggesterStepOneBinding, MealsSuggesterUiState , MealsSuggesterViewModel>() {
    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_food_suggester_step_one
    override val viewModel: MealsSuggesterViewModel by viewModels()
 }