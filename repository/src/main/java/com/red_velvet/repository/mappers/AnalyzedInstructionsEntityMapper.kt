package com.red_velvet.repository.mappers



import com.red_velvet.domain.models.recipes.AnalyzedInstructionsEntity
import com.red_velvet.repository.resources.AnalyzedInstructionResource
import com.red_velvet.repository.resources.StepResource


internal fun List<AnalyzedInstructionResource>.toAnalyzedInstructionEntity(): List<AnalyzedInstructionsEntity> {
    return this.map {
        com.red_velvet.domain.models.recipes.AnalyzedInstructionsEntity(
            name = it.name,
            steps = it.steps.toListStep()
        )
    }
}

private fun List<StepResource>.toListStep(): List<com.red_velvet.domain.models.recipes.StepEntity> {
    return this.map {
        com.red_velvet.domain.models.recipes.StepEntity(
            number = it.number,
            step = it.step
        )
    }
}
