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

     fun IngredientInformationDto.toIngredientInformationDtoMapper(): IngredientInformation {
        return IngredientInformation(
            id  = this.id ?: 0,
            name = this.name?: "",
            image = this.image?: "",
            categoryPath = this.categoryPath?.filterNotNull() ?: emptyList(),
            nutrition = Nutrition(
                nutrients = this.nutrition?.nutrients?.map { it.mapToNutrients() } ?: emptyList(),
                properties = this.nutrition?.properties?.map { it.mapToProperties() } ?: emptyList(),
                weightPerServing = this.nutrition?.weightPerServing?.mapToWeightPerServing()!!
            ),
        )
    }
    private fun NutrientDto.mapToNutrients(): Nutrients {
        return Nutrients(
            amount = amount,
            percentOfDailyNeeds = percentOfDailyNeeds,
            name = name ?: "",
            unit = unit ?: ""
        )
    }

    private fun PropertyDto.mapToProperties(): Property {
        return Property(
            amount = amount,
            name = name ?: "",
            unit = unit ?: ""
        )
    }

    private fun WeightPerServingDto?.mapToWeightPerServing(): WeightPerServing {
        return WeightPerServing(
            amount = this?.amount,
            unit = this?.unit ?: ""
        )
    }

