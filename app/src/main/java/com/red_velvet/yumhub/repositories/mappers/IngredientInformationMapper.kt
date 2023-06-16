package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.ingredientInformation.IngredientInformationEntity
import com.red_velvet.yumhub.domain.models.ingredientInformation.NutrientsEntity
import com.red_velvet.yumhub.domain.models.ingredientInformation.NutritionEntity
import com.red_velvet.yumhub.domain.models.ingredientInformation.PropertyEntity
import com.red_velvet.yumhub.domain.models.ingredientInformation.WeightPerServingEntity
import com.red_velvet.yumhub.domain.utils.orEmptyList
import com.red_velvet.yumhub.domain.utils.orZero
import com.red_velvet.yumhub.remote.resources.ingredient.IngredientInformationResource
import com.red_velvet.yumhub.remote.resources.ingredient.NutrientResource

fun IngredientInformationResource.toIngredientInformation(): IngredientInformationEntity {
    return IngredientInformationEntity(
        id = id.orZero(),
        name = name.orEmpty(),
        image = image.orEmpty(),
        categoryPath = categoryPath?.filterNotNull(),
        nutritionEntity = NutritionEntity(
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

private fun com.red_velvet.yumhub.remote.resources.PropertyResource.toProperties(): PropertyEntity {
    return PropertyEntity(
        amount = amount.orZero(),
        name = name.orEmpty(),
        unit = unit.orEmpty(),
    )
}

private fun com.red_velvet.yumhub.remote.resources.WeightPerServingResource?.toWeightPerServing(): WeightPerServingEntity? {
    return this?.let {
        WeightPerServingEntity(
            amount = it.amount.orZero(),
            unit = it.unit.orEmpty(),
        )
    }
}

