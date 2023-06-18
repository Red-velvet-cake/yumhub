package com.red_velvet.yumhub.repositories.mappers


import com.red_velvet.yumhub.domain.models.recipes.AnalyzedInstructionsEntity
import com.red_velvet.yumhub.domain.models.recipes.StepEntity
import com.red_velvet.yumhub.remote.resources.AnalyzedInstructionResource
import com.red_velvet.yumhub.remote.resources.StepResource

fun List<AnalyzedInstructionResource>.toAnalyzedInstructionEntity(): List<AnalyzedInstructionsEntity> {
    return this.map {
        AnalyzedInstructionsEntity(
            name = it.name,
            steps = it.steps.toListStep()
        )
    }
}

private fun List<StepResource>.toListStep(): List<StepEntity> {
    return this.map {
        StepEntity(
            number = it.number,
            step = it.step
        )
    }
}
