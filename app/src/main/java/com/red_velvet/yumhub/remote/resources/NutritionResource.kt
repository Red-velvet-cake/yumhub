package com.red_velvet.yumhub.remote.resources


import com.google.gson.annotations.SerializedName

data class NutritionResource(
    @SerializedName("caloricBreakdown")
    val caloricBreakdown: com.red_velvet.yumhub.remote.resources.CaloricBreakdownResource? = com.red_velvet.yumhub.remote.resources.CaloricBreakdownResource(),
    @SerializedName("flavonoids")
    val flavonoids: List<com.red_velvet.yumhub.remote.resources.FlavonoidResource>? = listOf(),
    @SerializedName("ingredients")
    val ingredients: List<com.red_velvet.yumhub.remote.resources.ingredient.IngredientInformationResource>? = listOf(),
    @SerializedName("nutrients")
    val nutrients: List<com.red_velvet.yumhub.remote.resources.ingredient.NutrientResource>? = listOf(),
    @SerializedName("properties")
    val properties: List<com.red_velvet.yumhub.remote.resources.PropertyResource>? = listOf(),
    @SerializedName("weightPerServing")
    val weightPerServing: com.red_velvet.yumhub.remote.resources.WeightPerServingResource? = com.red_velvet.yumhub.remote.resources.WeightPerServingResource()
)