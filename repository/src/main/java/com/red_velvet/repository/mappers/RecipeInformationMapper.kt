package com.red_velvet.repository.mappers

import com.red_velvet.domain.models.recipes.AnalyzedInstructionsEntity
import com.red_velvet.domain.models.recipes.EquipmentEntity
import com.red_velvet.domain.models.recipes.ExtendedIngredientEntity
import com.red_velvet.domain.models.recipes.IngredientsEntity
import com.red_velvet.domain.models.recipes.LengthEntity
import com.red_velvet.domain.models.recipes.RecipeInformationEntity
import com.red_velvet.domain.models.recipes.StepEntity
import com.red_velvet.repository.resources.AnalyzedInstructionResource
import com.red_velvet.repository.resources.EquipmentResource
import com.red_velvet.repository.resources.ExtendedIngredientResource
import com.red_velvet.repository.resources.IngredientResource
import com.red_velvet.repository.resources.LengthResource
import com.red_velvet.repository.resources.StepResource
import com.red_velvet.repository.resources.recipe.RecipeInformationResource
import com.red_velvet.repository.utils.orEmptyList
import com.red_velvet.repository.utils.orFalse
import com.red_velvet.repository.utils.orZero

internal fun RecipeInformationResource.toEntity(): RecipeInformationEntity {
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
        analyzedInstructions = analyzedInstructions?.map { it.toModel() } ?: emptyList(),
        cheap = this.cheap.orFalse(),
        cookingMinutes = this.cookingMinutes.orZero(),
        cuisines = this.cuisines ?: emptyList(),
        diets = this.diets ?: emptyList(),
        dishTypes = this.dishTypes ?: emptyList(),
        extendedIngredientEntities = extendedIngredients.map { it.toModel() },
        glutenFree = this.glutenFree.orFalse(),
        healthScore = this.healthScore.orZero()
    )
}

fun AnalyzedInstructionResource.toModel(): AnalyzedInstructionsEntity {
    return AnalyzedInstructionsEntity(
        name = name.orEmpty(),
        steps = steps.map {
            it.toModel()
        }
    )
}

fun StepResource.toModel(): StepEntity {
    return StepEntity(
        equipmentEntities = equipment.map {
            it.toModel()
        },
        lengthEntity = length.toModel(),
        number = number.orZero(),
        step = step.orEmpty(),
        ingredientsEntity = ingredients?.map {
            it!!.toModel()
        }.orEmptyList()
    )
}
fun IngredientResource.toModel(): IngredientsEntity {
    return IngredientsEntity(
        id = id.orZero(),
        image = image.orEmpty(),
        localizedName = localizedName.orEmpty(),
        name = name.orEmpty()
    )
}
fun EquipmentResource.toModel(): EquipmentEntity {
    return EquipmentEntity(
        id = id.orZero(),
        image = image.orEmpty(),
        localizedName = localizedName.orEmpty(),
        name = name.orEmpty()
    )
}

fun LengthResource.toModel(): LengthEntity {
    return LengthEntity(
        number = number.orZero(),
        unit = unit.orEmpty()
    )
}

fun ExtendedIngredientResource.toModel(): ExtendedIngredientEntity {
    return ExtendedIngredientEntity(
        aisle = aisle.orEmpty(),
        amount = amount.orZero(),
        id = id.orZero(),
        image = image.orEmpty(),
        name = name.orEmpty(),
        unit = unit.orEmpty()
    )
}