package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.remote.dtos.PropertyDto
import com.red_velvet.yumhub.data.remote.dtos.WeightPerServingDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientInformationDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.NutrientDto
import com.red_velvet.yumhub.domain.models.ingredientInformation.IngredientInformation
import com.red_velvet.yumhub.domain.models.ingredientInformation.Nutrients
import com.red_velvet.yumhub.domain.models.ingredientInformation.Nutrition
import com.red_velvet.yumhub.domain.models.ingredientInformation.Property
import com.red_velvet.yumhub.domain.models.ingredientInformation.WeightPerServing
import com.red_velvet.yumhub.domain.utils.orEmptyList
import com.red_velvet.yumhub.domain.utils.orZero

fun IngredientInformationDto.toIngredientInformation(): IngredientInformation {
        return IngredientInformation(
            id  = id.orZero(),
            name = name.orEmpty(),
            image = image.orEmpty(),
            categoryPath = categoryPath?.filterNotNull(),
            nutrition = Nutrition(
                nutrients = nutrition?.nutrients?.map { it.toNutrients() }.orEmptyList(),
                properties = nutrition?.properties?.map { it.toProperties() }.orEmptyList(),
                weightPerServing =nutrition?.weightPerServing?.toWeightPerServing()?: WeightPerServing(0, "")
            ),
        )
    }
    private fun NutrientDto.toNutrients(): Nutrients {
        return Nutrients(
            amount = amount.orZero(),
            percentOfDailyNeeds = percentOfDailyNeeds.orZero(),
            name = name.orEmpty() ,
            unit = unit.orEmpty()
        )
    }

    private fun PropertyDto.toProperties(): Property {
        return Property(
            amount = amount.orZero(),
            name = name.orEmpty() ,
            unit = unit.orEmpty() ,
        )
    }

private fun WeightPerServingDto?.toWeightPerServing(): WeightPerServing? {
    return this?.let {
        WeightPerServing(
            amount = it.amount.orZero(),
            unit = it.unit.orEmpty() ,
        )
    }
}

