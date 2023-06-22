package com.red_velvet.yumhub.ui.deit

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentDeitBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DietFragment : BaseFragment<FragmentDeitBinding, DietUIState, DietUIEffect, DietViewModel>() {

    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_deit
    override val viewModel: DietViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val dietAdapter = DietAdapter(mutableListOf(), viewModel)
        binding.recipeDietRecyclerView.adapter = dietAdapter
        super.onViewCreated(view, savedInstanceState)
    }

    override fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collectLatest { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: DietUIEffect) {
        when (uiEffect) {
            is DietUIEffect.ClickOnRecipe -> onClickRecipe(uiEffect.recipeId)
        }
    }

    private fun onClickRecipe(recipeId: Int) {
        val directions =
            DietFragmentDirections.actionDietFragmentToRecipeInformationFragment(recipeId)
        findNavController().navigate(directions)
    }
}