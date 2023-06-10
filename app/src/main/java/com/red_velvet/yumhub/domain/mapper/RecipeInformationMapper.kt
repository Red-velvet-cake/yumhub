package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.domain.models.recipes.AnalyzedInstructionsEntity
import com.red_velvet.yumhub.domain.models.recipes.EquipmentEntity
import com.red_velvet.yumhub.domain.models.recipes.ExtendedIngredientEntity
import com.red_velvet.yumhub.domain.models.recipes.LengthEntity
import com.red_velvet.yumhub.domain.models.recipes.RecipeInformationEntity
import com.red_velvet.yumhub.domain.models.recipes.StepEntity
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orFalse
import com.red_velvet.yumhub.domain.utils.orZero

fun com.red_velvet.yumhub.remote.dtos.recipe.RecipeInformationDto.toModel(): RecipeInformationEntity {
    return RecipeInformationEntity(
        id = this.id.orZero(),
        image = this.image.orEmpty(),
        imageType = this.imageType.orEmpty(),
        instructions = this.instructions.orEmpty(),
        preparationMinutes = this.preparationMinutes.orZero(),
        pricePerServing = this.pricePerServing.orZero(),
        readyInMinutes = this.readyInMinutes.orZero(),
        servings = this.servings.orZero(),
        summary = this.summary.orEmpty(),
        title = this.title.orEmpty(),
        analyzedInstructionEntities = analyzedInstructions.map { it.toModel() },
        cheap = this.cheap.orFalse(),
        cookingMinutes = this.cookingMinutes.orZero(),
        cuisines = this.cuisines,
        diets = this.diets,
        dishTypes = this.dishTypes,
        extendedIngredientEntities = extendedIngredients.map { it.toModel() },
        glutenFree = this.glutenFree.orFalse(),
        healthScore = this.healthScore.orZero()
    )
}

fun com.red_velvet.yumhub.remote.dtos.AnalyzedInstructionDto.toModel(): AnalyzedInstructionsEntity {
    return AnalyzedInstructionsEntity(
        name = name.orEmpty(),
        stepEntities = steps.map {
            it.toModel()
        }
    )
}

fun com.red_velvet.yumhub.remote.dtos.StepDto.toModel(): StepEntity {
    return StepEntity(
        equipmentEntities = equipment.map {
            it.toModel()
        },
        lengthEntity = length.toModel(),
        number = number.orZero(),
        step = step.orEmpty()
    )
}

fun com.red_velvet.yumhub.remote.dtos.EquipmentDto.toModel(): EquipmentEntity {
    return EquipmentEntity(
        id = id.orZero(),
        image = image.orEmpty(),
        localizedName = localizedName.orEmpty(),
        name = name.orEmpty()
    )
}

fun com.red_velvet.yumhub.remote.dtos.LengthDto.toModel(): LengthEntity {
    return LengthEntity(
        number = number.orZero(),
        unit = unit.orEmpty()
    )
}

fun com.red_velvet.yumhub.remote.dtos.ExtendedIngredientDto.toModel(): ExtendedIngredientEntity {
    return ExtendedIngredientEntity(
        aisle = aisle.orEmpty(),
        amount = amount.orZero(),
        id = id.orZero(),
        image = image.orEmpty(),
        name = name.orEmpty(),
        unit = unit.orEmpty()
    )
}