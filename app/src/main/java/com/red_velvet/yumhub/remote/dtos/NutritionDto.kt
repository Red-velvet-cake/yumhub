package com.red_velvet.yumhub.remote.dtos


import com.google.gson.annotations.SerializedName

data class NutritionDto(
    @SerializedName("caloricBreakdown")
    val caloricBreakdown: com.red_velvet.yumhub.remote.dtos.CaloricBreakdownDto? = com.red_velvet.yumhub.remote.dtos.CaloricBreakdownDto(),
    @SerializedName("flavonoids")
    val flavonoids: List<com.red_velvet.yumhub.remote.dtos.FlavonoidDto>? = listOf(),
    @SerializedName("ingredients")
    val ingredients: List<com.red_velvet.yumhub.remote.dtos.ingredient.IngredientInformationDto>? = listOf(),
    @SerializedName("nutrients")
    val nutrients: List<com.red_velvet.yumhub.remote.dtos.ingredient.NutrientDto>? = listOf(),
    @SerializedName("properties")
    val properties: List<com.red_velvet.yumhub.remote.dtos.PropertyDto>? = listOf(),
    @SerializedName("weightPerServing")
    val weightPerServing: com.red_velvet.yumhub.remote.dtos.WeightPerServingDto? = com.red_velvet.yumhub.remote.dtos.WeightPerServingDto()
)