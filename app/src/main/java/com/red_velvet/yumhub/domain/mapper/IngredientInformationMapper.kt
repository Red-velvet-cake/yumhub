package com.red_velvet.yumhub.domain.mapper

import com.karrar.movieapp.domain.mappers.Mapper
import com.red_velvet.yumhub.data.remote.dtos.PropertyDto
import com.red_velvet.yumhub.data.remote.dtos.WeightPerServingDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientInformationDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSubstituteDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.NutrientDto
import com.red_velvet.yumhub.domain.models.IngredientInformation
import com.red_velvet.yumhub.domain.models.IngredientSubstitutes
import com.red_velvet.yumhub.domain.models.Nutrients
import com.red_velvet.yumhub.domain.models.Nutrition
import com.red_velvet.yumhub.domain.models.Property
import com.red_velvet.yumhub.domain.models.WeightPerServing
import javax.inject.Inject

class IngredientInformationMapper  @Inject constructor() :
    Mapper<IngredientInformationDto, IngredientInformation> {
    override fun map(input: IngredientInformationDto): IngredientInformation {
        return IngredientInformation(
            id  = input.id ?: 0,
            name = input.name?: "",
            image = input.image?: "",
            categoryPath = input.categoryPath?.filterNotNull() ?: emptyList(),
            nutrition = Nutrition(
                nutrients = input.nutrition?.nutrients?.map { mapNutrientDtoToNutrients(it) } ?: emptyList(),
                properties = input.nutrition?.properties?.map { mapPropertiesDtoToProperties(it) } ?: emptyList(),
                weightPerServing = mapWeightPerServingDtoToWeightPerServing(input.nutrition?.weightPerServing)
            )
        )
    }

    private fun mapNutrientDtoToNutrients(nutrientDto: NutrientDto): Nutrients {
        return Nutrients(
            amount = nutrientDto.amount,
            percentOfDailyNeeds = nutrientDto.percentOfDailyNeeds,
            name = nutrientDto.name ?: "",
            unit = nutrientDto.unit ?: ""
        )
    }

    private fun mapPropertiesDtoToProperties(propertiesDto: PropertyDto): Property {
        return Property(
            amount = propertiesDto.amount,
            name = propertiesDto.name ?: "",
            unit = propertiesDto.unit ?: ""
        )
    }

    private fun mapWeightPerServingDtoToWeightPerServing(weightPerServingDto: WeightPerServingDto?): WeightPerServing {
        return WeightPerServing(
            amount = weightPerServingDto?.amount,
            unit = weightPerServingDto?.unit ?: ""
        )
    }
}
