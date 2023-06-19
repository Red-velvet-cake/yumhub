package com.red_velvet.repository.mappers

import com.red_velvet.domain.models.ingredientInformation.IngredientInformationEntity
import com.red_velvet.domain.models.ingredientInformation.NutrientsEntity
import com.red_velvet.domain.models.ingredientInformation.PropertyEntity
import com.red_velvet.domain.models.ingredientInformation.WeightPerServingEntity
import com.red_velvet.repository.resources.PropertyResource
import com.red_velvet.repository.resources.WeightPerServingResource
import com.red_velvet.repository.resources.ingredient.IngredientInformationResource
import com.red_velvet.repository.resources.ingredient.NutrientResource
import com.red_velvet.repository.utils.orEmptyList
import com.red_velvet.repository.utils.orZero


internal fun IngredientInformationResource.toIngredientInformation(): IngredientInformationEntity {
    return IngredientInformationEntity(
        id = id.orZero(),
        name = name.orEmpty(),
        image = image.orEmpty(),
        categoryPath = categoryPath?.filterNotNull(),
        nutritionEntity = com.red_velvet.domain.models.ingredientInformation.NutritionEntity(
            nutrients = nutrition?.nutrients?.map { it.toNutrients() }.orEmptyList(),
            properties = nutrition?.properties?.map { it.toProperties() }.orEmptyList(),
            weightPerServingEntity = nutrition?.weightPerServing?.toWeightPerServing()
                ?: WeightPerServingEntity(0, "")
        ),
    )
}

private fun NutrientResource.toNutrients(): NutrientsEntity {
    return NutrientsEntity(
        amount = amount.orZero(),
        percentOfDailyNeeds = percentOfDailyNeeds.orZero(),
        name = name.orEmpty(),
        unit = unit.orEmpty()
    )
}

private fun PropertyResource.toProperties(): PropertyEntity {
    return PropertyEntity(
        amount = amount.orZero(),
        name = name.orEmpty(),
        unit = unit.orEmpty(),
    )
}

private fun WeightPerServingResource?.toWeightPerServing(): WeightPerServingEntity? {
    return this?.let {
        WeightPerServingEntity(
            amount = it.amount.orZero(),
            unit = it.unit.orEmpty(),
        )
    }
}

