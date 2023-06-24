package com.red_velvet.yumhub.ui.history

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentHistoryBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HistoryFragment :
    BaseFragment<FragmentHistoryBinding, HistoryUIState, HistoryUIEffect, HistoryViewModel>() {

    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_history
    override val viewModel: HistoryViewModel by viewModels()

    override fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collectLatest { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: HistoryUIEffect) {
        when (uiEffect) {
            is HistoryUIEffect.ClickOnItem -> onRecipeClicked(uiEffect.itemId)
        }
    }

    private fun onRecipeClicked(itemId: Int) {
        val directions =
            HistoryFragmentDirections.actionHistoryFragmentToRecipeInformationFragment(itemId)
        findNavController().navigate(directions)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val historyAdapter = HistoryAdapter(mutableListOf(), viewModel)
        binding.recyclerHistoryList.adapter = historyAdapter
        super.onViewCreated(view, savedInstanceState)
    }
}