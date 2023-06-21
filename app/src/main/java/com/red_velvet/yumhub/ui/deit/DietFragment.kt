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
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DietFragment  : BaseFragment<FragmentDeitBinding, DietUIState, DietViewModel>(){
    @LayoutRes
    override val layoutIdFragment: Int= R.layout.fragment_deit
    override val viewModel: DietViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val dietAdapter = DietAdapter(mutableListOf(),viewModel)
        binding.recipeDietRecyclerView.adapter = dietAdapter
        observeOnUIEffects()
        super.onViewCreated(view, savedInstanceState)
    }
    private fun observeOnUIEffects() {
        lifecycleScope.launch {
            when (val effect = viewModel.effect.first()) {
                is DietUIEffect.ClickOnRecipe -> onClickRecipe(effect.recipeId)
            }
        }
    }
    private fun onClickRecipe(recipeId: Int) {
        val directions =
            DietFragmentDirections.actionDietFragmentToRecipeInformationFragment()
        findNavController().navigate(directions)
    }
}