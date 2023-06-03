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

     fun IngredientInformationDto.toIngredientInformation(): IngredientInformation {
        return IngredientInformation(
            id  = id ?: 0,
            name = name?: "",
            image = image?: "",
            categoryPath = categoryPath?.filterNotNull() ?: emptyList(),
            nutrition = Nutrition(
                nutrients = nutrition?.nutrients?.map { it.toNutrients() } ?: emptyList(),
                properties = nutrition?.properties?.map { it.toProperties() } ?: emptyList(),
                weightPerServing =nutrition?.weightPerServing?.toWeightPerServing()?: WeightPerServing(0, "")
            ),
        )
    }
    private fun NutrientDto.toNutrients(): Nutrients {
        return Nutrients(
            amount = amount,
            percentOfDailyNeeds = percentOfDailyNeeds,
            name = name ?: "",
            unit = unit ?: ""
        )
    }

    private fun PropertyDto.toProperties(): Property {
        return Property(
            amount = amount,
            name = name ?: "",
            unit = unit ?: ""
        )
    }

private fun WeightPerServingDto?.toWeightPerServing(): WeightPerServing? {
    return this?.let {
        WeightPerServing(
            amount = it.amount ?: 0,
            unit = it.unit ?: ""
        )
    }
}

