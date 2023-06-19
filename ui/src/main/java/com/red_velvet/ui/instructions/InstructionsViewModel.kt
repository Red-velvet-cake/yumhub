package com.red_velvet.ui.instructions

import com.red_velvet.domain.usecases.GetAnalyzedRecipeInstructionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class InstructionsViewModel @Inject constructor(
    private val getRecipeInstructions: GetAnalyzedRecipeInstructionsUseCase,
) : com.red_velvet.ui.base.BaseViewModel<InstructionsUIState>(InstructionsUIState()),
    StepsInteractionListener {

    init {
        getAnalyzedRecipeInstructions(660228)
    }

    private fun getAnalyzedRecipeInstructions(id: Int) {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getRecipeInstructions(id) },
            onSuccess = ::getAnalyzedRecipeInstructionsSuccess,
            onError = ::onError
        )

    }

    private fun onError(errorUiState: com.red_velvet.ui.base.ErrorUIState) {
        _state.update { it.copy(error = errorUiState, isLoading = false) }
    }

    private fun getAnalyzedRecipeInstructionsSuccess(
        analyzedRecipeInstructions: List<com.red_velvet.domain.models.recipes.AnalyzedInstructionsEntity>,
    ) {
        val steps = analyzedRecipeInstructions.toAnalyzedInstructionUiState().flatMap { it.steps }
        _state.update { it.copy( steps = steps, isLoading = false) }
    }

}