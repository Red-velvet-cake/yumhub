package com.red_velvet.yumhub.remote.resources


import com.google.gson.annotations.SerializedName

data class NutritionDto(
    @SerializedName("caloricBreakdown")
    val caloricBreakdown: com.red_velvet.yumhub.remote.resources.CaloricBreakdownDto? = com.red_velvet.yumhub.remote.resources.CaloricBreakdownDto(),
    @SerializedName("flavonoids")
    val flavonoids: List<com.red_velvet.yumhub.remote.resources.FlavonoidDto>? = listOf(),
    @SerializedName("ingredients")
    val ingredients: List<com.red_velvet.yumhub.remote.resources.ingredient.IngredientInformationDto>? = listOf(),
    @SerializedName("nutrients")
    val nutrients: List<com.red_velvet.yumhub.remote.resources.ingredient.NutrientDto>? = listOf(),
    @SerializedName("properties")
    val properties: List<com.red_velvet.yumhub.remote.resources.PropertyDto>? = listOf(),
    @SerializedName("weightPerServing")
    val weightPerServing: com.red_velvet.yumhub.remote.resources.WeightPerServingDto? = com.red_velvet.yumhub.remote.resources.WeightPerServingDto()
)