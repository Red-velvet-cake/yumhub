package com.red_velvet.yumhub.ui.mealsSuggester

import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentMealsSuggesterBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealsSuggesterFragment:BaseFragment<FragmentMealsSuggesterBinding, MealsSuggesterUiState , MealsSuggesterViewModel>() {
    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_meals_suggester
    override val viewModel: MealsSuggesterViewModel by viewModels()
 }