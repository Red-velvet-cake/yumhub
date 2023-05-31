package com.red_velvet.yumhub.data.remote.dtos


import com.google.gson.annotations.SerializedName
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientInformationDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.NutrientDto

data class NutritionDto(
    @SerializedName("caloricBreakdown")
    val caloricBreakdown: CaloricBreakdownDto? = CaloricBreakdownDto(),
    @SerializedName("flavonoids")
    val flavonoids: List<FlavonoidDto>? = listOf(),
    @SerializedName("ingredients")
    val ingredients: List<IngredientInformationDto>? = listOf(),
    @SerializedName("nutrients")
    val nutrients: List<NutrientDto>? = listOf(),
    @SerializedName("properties")
    val properties: List<PropertyDto>? = listOf(),
    @SerializedName("weightPerServing")
    val weightPerServing: WeightPerServingDto? = WeightPerServingDto()
)