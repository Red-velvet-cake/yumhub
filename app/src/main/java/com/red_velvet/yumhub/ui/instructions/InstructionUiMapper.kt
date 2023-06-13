package com.red_velvet.yumhub.ui.instructions

import com.red_velvet.yumhub.domain.models.recipes.AnalyzedInstructionsEntity
import com.red_velvet.yumhub.domain.models.recipes.Step

fun List<AnalyzedInstructionsEntity>.toAnalyzedInstructionUiState(): List<InstructionsUIState> {
    return this.map {
        InstructionsUIState(
            steps = it.steps.toStepsUIState()
        )
    }
}
 fun List<Step>.toStepsUIState(): List<StepsUiState>{
    return this.map {
        StepsUiState(
            stepNumber = it.number,
            stepDetails = it.step
        )
    }
}