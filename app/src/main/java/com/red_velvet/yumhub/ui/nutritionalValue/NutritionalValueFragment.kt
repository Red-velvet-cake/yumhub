package com.red_velvet.yumhub.ui.nutritionalValue

import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentNutritionalValueBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NutritionalValueFragment : BaseFragment<FragmentNutritionalValueBinding,
        NutritionalValueUIState, NutritionalValueUIEffect, NutritionalValueViewModel>() {

    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_nutritional_value
    override val viewModel: NutritionalValueViewModel by viewModels()

    override fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collectLatest { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: NutritionalValueUIEffect) {
        when (uiEffect) {
            NutritionalValueUIEffect.InvalidSearchInput -> onInvalidInputs()
        }
    }

    private fun onInvalidInputs() {
        Snackbar.make(binding.imageViewCarbs, "Enter correct recipe name", Snackbar.LENGTH_SHORT)
            .show()
    }

}