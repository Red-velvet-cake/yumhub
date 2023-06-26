package com.red_velvet.yumhub.ui.fnd_meal

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentFindYourMealBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FindYourMealFragment
    : BaseFragment<FragmentFindYourMealBinding,
        FindYourMealUiState,
        FindYourMaelUiEffect,
        FindYourMealViewModel>()
{
    @LayoutRes
    override val layoutIdFragment = R.layout.fragment_find_your_meal
    override val viewModel: FindYourMealViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fndYourMealAdapter = FindYourMealAdapter(mutableListOf(), viewModel)
        binding.recyclerFindYourMealResult.adapter = fndYourMealAdapter
    }


    override fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collectLatest { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: FindYourMaelUiEffect) {
        TODO("Not yet implemented")
    }
}