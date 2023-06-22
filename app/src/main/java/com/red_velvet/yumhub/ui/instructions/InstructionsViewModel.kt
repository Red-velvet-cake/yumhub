package com.red_velvet.yumhub.ui.instructions

import androidx.lifecycle.SavedStateHandle
import com.red_velvet.yumhub.domain.models.recipes.AnalyzedInstructionsEntity
import com.red_velvet.yumhub.domain.usecases.GetAnalyzedRecipeInstructionsUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class InstructionsViewModel @Inject constructor(
    private val getRecipeInstructions: GetAnalyzedRecipeInstructionsUseCase,
    savedState: SavedStateHandle
) : BaseViewModel<InstructionsUIState, InstructionsUIEffect>(InstructionsUIState()),
    StepsInteractionListener {

    private val args = InstructionsFragmentArgs.fromSavedStateHandle(savedState)

    init {
        getAnalyzedRecipeInstructions(args.id)
    }

    private fun getAnalyzedRecipeInstructions(id: Int) {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getRecipeInstructions(id) },
            onSuccess = ::getAnalyzedRecipeInstructionsSuccess,
            onError = ::onError
        )

    }

    private fun onError(errorUiState: ErrorUIState) {
        _state.update { it.copy(error = errorUiState, isLoading = false) }
    }

    private fun getAnalyzedRecipeInstructionsSuccess(
        analyzedRecipeInstructions: List<AnalyzedInstructionsEntity>,
    ) {
        val steps = analyzedRecipeInstructions.toAnalyzedInstructionUiState().flatMap { it.steps }
        _state.update { it.copy(steps = steps, isLoading = false) }
    }

}