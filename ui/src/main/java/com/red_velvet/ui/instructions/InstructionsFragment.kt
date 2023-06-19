package com.red_velvet.ui.instructions

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.red_velvet.mylibrary.R
import com.red_velvet.mylibrary.databinding.FragmentInstructionsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InstructionsFragment :
    com.red_velvet.ui.base.BaseFragment<FragmentInstructionsBinding, InstructionsUIState, InstructionsViewModel>() {
    override val layoutIdFragment = R.layout.fragment_instructions
    override val viewModel: InstructionsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val instructionsAdapter = InstructionsAdapter(emptyList(),viewModel)
        binding.instructionsRecyclerView.adapter = instructionsAdapter
    }
}