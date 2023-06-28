package com.red_velvet.yumhub.ui.nutritionl_info_type_good

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentGoodNutritionInfoBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import com.red_velvet.yumhub.ui.nutrition_info.NutritionInfoUiEffect
import com.red_velvet.yumhub.ui.nutrition_info.NutritionInfoUiState
import com.red_velvet.yumhub.ui.nutrition_info.NutritionInfoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GoodNutritionInfoFragment : BaseFragment<FragmentGoodNutritionInfoBinding,
        NutritionInfoUiState,
        NutritionInfoUiEffect,
        NutritionInfoViewModel>() {
    override val layoutIdFragment = R.layout.fragment_good_nutrition_info


    override val viewModel: NutritionInfoViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val goodNutritionInfoAdapter = GoodNutritionInfoAdapter(mutableListOf())
        binding.recyclerGoodContentResult.adapter = goodNutritionInfoAdapter
    }
    override fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collectLatest { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: NutritionInfoUiEffect) {
    }
}