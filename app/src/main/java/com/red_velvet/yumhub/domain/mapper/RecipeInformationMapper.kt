package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.remote.dtos.AnalyzedInstructionDto
import com.red_velvet.yumhub.data.remote.dtos.EquipmentDto
import com.red_velvet.yumhub.data.remote.dtos.ExtendedIngredientDto
import com.red_velvet.yumhub.data.remote.dtos.IngredientDto
import com.red_velvet.yumhub.data.remote.dtos.LengthDto
import com.red_velvet.yumhub.data.remote.dtos.StepDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeInformationDto
import com.red_velvet.yumhub.domain.models.recipes.AnalyzedInstructions
import com.red_velvet.yumhub.domain.models.recipes.Equipment
import com.red_velvet.yumhub.domain.models.recipes.ExtendedIngredient
import com.red_velvet.yumhub.domain.models.recipes.Ingredients
import com.red_velvet.yumhub.domain.models.recipes.Length
import com.red_velvet.yumhub.domain.models.recipes.RecipeInformation
import com.red_velvet.yumhub.domain.models.recipes.Step
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orEmptyList
import com.red_velvet.yumhub.domain.utils.orFalse
import com.red_velvet.yumhub.domain.utils.orZero

fun RecipeInformationDto.toModel(): RecipeInformation {
    return RecipeInformation(
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
        analyzedInstructions = analyzedInstructions.map { it.toModel() },
        cheap = this.cheap.orFalse(),
        cookingMinutes = this.cookingMinutes.orZero(),
        cuisines = this.cuisines,
        diets = this.diets,
        dishTypes = this.dishTypes,
        extendedIngredients = extendedIngredients.map { it.toModel() },
        glutenFree = this.glutenFree.orFalse(),
        healthScore = this.healthScore.orZero()
    )
}

fun AnalyzedInstructionDto.toModel(): AnalyzedInstructions {
    return AnalyzedInstructions(
        name = name.orEmpty(),
        steps = steps.map {
            it.toModel()
        }
    )
}

fun StepDto.toModel(): Step {
    return Step(
        equipment = equipment.map {
            it.toModel()
        },
        length = length.toModel(),
        number = number.orZero(),
        step = step.orEmpty(),
        ingredients = ingredients?.map { it!!.toModel() }.orEmptyList()
    )
}

fun EquipmentDto.toModel(): Equipment {
    return Equipment(
        id = id.orZero(),
        image = image.orEmpty(),
        localizedName = localizedName.orEmpty(),
        name = name.orEmpty()
    )
}

fun LengthDto.toModel(): Length {
    return Length(
        number = number.orZero(),
        unit = unit.orEmpty()
    )
}

fun ExtendedIngredientDto.toModel(): ExtendedIngredient {
    return ExtendedIngredient(
        aisle = aisle.orEmpty(),
        amount = amount.orZero(),
        id = id.orZero(),
        image = image.orEmpty(),
        name = name.orEmpty(),
        unit = unit.orEmpty()
    )
}