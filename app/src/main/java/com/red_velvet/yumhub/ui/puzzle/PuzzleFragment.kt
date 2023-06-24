package com.red_velvet.yumhub.ui.puzzle

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentPuzzleBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PuzzleFragment : BaseFragment<FragmentPuzzleBinding, PuzzleUIState, PuzzleViewModel>(),
    OnPuzzleSolvedListener {
    override val layoutIdFragment: Int = R.layout.fragment_puzzle
    override val viewModel: PuzzleViewModel by viewModels()
    private var puzzleSolved: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.puzzleView.onPuzzleSolvedListener = this
    }

    override fun onPuzzleSolved() {
        puzzleSolved = true
        Snackbar.make(requireView(), "Puzzle Solved!", Snackbar.LENGTH_LONG).show()
    }
}