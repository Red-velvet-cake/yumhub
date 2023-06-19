package com.red_velvet.repository.resources


import com.google.gson.annotations.SerializedName

data class NutritionResource(
    @SerializedName("caloricBreakdown")
    val caloricBreakdown: com.red_velvet.repository.resources.CaloricBreakdownResource? = com.red_velvet.repository.resources.CaloricBreakdownResource(),
    @SerializedName("flavonoids")
    val flavonoids: List<com.red_velvet.repository.resources.FlavonoidResource>? = listOf(),
    @SerializedName("ingredients")
    val ingredients: List<com.red_velvet.repository.resources.ingredient.IngredientInformationResource>? = listOf(),
    @SerializedName("nutrients")
    val nutrients: List<com.red_velvet.repository.resources.ingredient.NutrientResource>? = listOf(),
    @SerializedName("properties")
    val properties: List<com.red_velvet.repository.resources.PropertyResource>? = listOf(),
    @SerializedName("weightPerServing")
    val weightPerServing: com.red_velvet.repository.resources.WeightPerServingResource? = com.red_velvet.repository.resources.WeightPerServingResource()
)