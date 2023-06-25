package com.red_velvet.yumhub.ui.puzzle

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentPuzzleBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PuzzleFragment : BaseFragment<FragmentPuzzleBinding, PuzzleUIState, PuzzleViewModel>(),
    OnPuzzleSolvedListener, OnPuzzleFailedListener {
    override val layoutIdFragment: Int = R.layout.fragment_puzzle
    override val viewModel: PuzzleViewModel by viewModels()
    private var puzzleSolved: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.puzzleView.setupPuzzle(2, 2)
        binding.puzzleView.onPuzzleSolvedListener = this
        binding.puzzleView.onPuzzleFailedListener = this
        binding.puzzleView.timerTextView = binding.timerTextView
    }

    override fun onPuzzleSolved() {
        puzzleSolved = true
        AlertDialog.Builder(requireContext())
            .setTitle("You solve the puzzle in time!")
            .setMessage("Do you want to play next level?")
            .setPositiveButton("Yes") { _, _ ->
                puzzleSolved = false
                binding.puzzleView.setupPuzzle(3, 3)
            }
            .setNegativeButton("No"){_, _ ->
                puzzleSolved = false
                binding.puzzleView.setupPuzzle(2, 2)
            }
            .show()
    }

    override fun onPuzzleFailed() {
        AlertDialog.Builder(requireContext())
            .setTitle("You didn't solve the puzzle in time!")
            .setMessage("Do you want to retry?")
            .setPositiveButton("Yes") { _, _ ->
                puzzleSolved = false
                binding.puzzleView.setupPuzzle(2, 2)
            }
            .setNegativeButton("No"){_, _ ->
                puzzleSolved = false
            }
            .show()
    }
}