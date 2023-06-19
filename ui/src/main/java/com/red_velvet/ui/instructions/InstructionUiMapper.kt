package com.red_velvet.ui.instructions

import com.red_velvet.domain.models.recipes.AnalyzedInstructionsEntity
import com.red_velvet.domain.models.recipes.StepEntity

fun List<AnalyzedInstructionsEntity>.toAnalyzedInstructionUiState(): List<InstructionsUIState> {
    return this.map {
        InstructionsUIState(
            steps = it.steps.toStepsUIState(it.name),
            name = it.name,
        )
    }
}
fun List<StepEntity>.toStepsUIState(name: String?): List<StepsUiState> {
    return this.map {
        StepsUiState(
            stepNumber = it.number,
            stepDetails = it.step,
            name = name
        )
    }
}