package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.domain.models.ingredientInformation.IngredientInformationEntity
import com.red_velvet.yumhub.domain.models.ingredientInformation.NutrientsEntity
import com.red_velvet.yumhub.domain.models.ingredientInformation.NutritionEntity
import com.red_velvet.yumhub.domain.models.ingredientInformation.PropertyEntity
import com.red_velvet.yumhub.domain.models.ingredientInformation.WeightPerServingEntity
import com.red_velvet.yumhub.domain.utils.orEmptyList
import com.red_velvet.yumhub.domain.utils.orZero

fun com.red_velvet.yumhub.remote.dtos.ingredient.IngredientInformationDto.toIngredientInformation(): IngredientInformationEntity {
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

private fun com.red_velvet.yumhub.remote.dtos.ingredient.NutrientDto.toNutrients(): NutrientsEntity {
    return NutrientsEntity(
        amount = amount.orZero(),
        percentOfDailyNeeds = percentOfDailyNeeds.orZero(),
        name = name.orEmpty(),
        unit = unit.orEmpty()
    )
}

private fun com.red_velvet.yumhub.remote.dtos.PropertyDto.toProperties(): PropertyEntity {
    return PropertyEntity(
        amount = amount.orZero(),
        name = name.orEmpty(),
        unit = unit.orEmpty(),
    )
}

private fun com.red_velvet.yumhub.remote.dtos.WeightPerServingDto?.toWeightPerServing(): WeightPerServingEntity? {
    return this?.let {
        WeightPerServingEntity(
            amount = it.amount.orZero(),
            unit = it.unit.orEmpty(),
        )
    }
}

