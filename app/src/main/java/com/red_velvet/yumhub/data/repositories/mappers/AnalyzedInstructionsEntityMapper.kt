package com.red_velvet.yumhub.data.repositories.mappers

import com.red_velvet.yumhub.data.remote.dtos.AnalyzedInstructionDto
import com.red_velvet.yumhub.data.remote.dtos.StepDto
import com.red_velvet.yumhub.domain.models.recipes.AnalyzedInstructionsEntity
import com.red_velvet.yumhub.domain.models.recipes.Step

fun List<AnalyzedInstructionDto>.toAnalyzedInstructionEntity(): List<AnalyzedInstructionsEntity> {
    return this.map {
        AnalyzedInstructionsEntity(
            name = it.name,
            steps = it.steps.toListStep()
        )
    }
}

private fun List<StepDto>.toListStep(): List<Step> {
    return this.map {
        Step(
            number = it.number,
            step = it.step
        )
    }
}
