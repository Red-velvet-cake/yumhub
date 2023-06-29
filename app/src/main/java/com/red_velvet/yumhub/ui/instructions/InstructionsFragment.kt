package com.red_velvet.yumhub.ui.instructions

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentInstructionsBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InstructionsFragment :
    BaseFragment<FragmentInstructionsBinding, InstructionsUIState, InstructionsUIEffect, InstructionsViewModel>() {
    override val layoutIdFragment = R.layout.fragment_instructions
    override val viewModel: InstructionsViewModel by viewModels()

    override fun observeOnUIEffects() {
//        TODO("Not yet implemented")
    }

    override fun handleUIEffect(uiEffect: InstructionsUIEffect) {
//        TODO("Not yet implemented")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val instructionsAdapter = InstructionsAdapter(emptyList(), viewModel)
        binding.instructionsRecyclerView.adapter = instructionsAdapter

        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Instructions"
    }
}