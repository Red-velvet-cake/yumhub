package com.red_velvet.yumhub.ui.nutrition_info_type_bad

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentBadNutritionInfoBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import com.red_velvet.yumhub.ui.nutrition_info.NutritionInfoUiEffect
import com.red_velvet.yumhub.ui.nutrition_info.NutritionInfoUiState
import com.red_velvet.yumhub.ui.nutrition_info.NutritionInfoViewModel
import com.red_velvet.yumhub.ui.nutritionl_info_type_good.GoodNutritionInfoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BadNutritionInfoFragment: BaseFragment<FragmentBadNutritionInfoBinding,
        NutritionInfoUiState,
        NutritionInfoUiEffect,
        NutritionInfoViewModel>() {
    override val layoutIdFragment = R.layout.fragment_bad_nutrition_info

    override val viewModel: NutritionInfoViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val badNutritionInfoAdapter = BadNutritionInfAdapter(mutableListOf())
        binding.recyclerBadContentResult.adapter = badNutritionInfoAdapter
    }
    override fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collectLatest { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: NutritionInfoUiEffect) {

    }
}