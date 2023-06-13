package com.red_velvet.yumhub.remote.resources


import com.google.gson.annotations.SerializedName
import com.red_velvet.yumhub.remote.resources.ingredient.IngredientInformationResource
import com.red_velvet.yumhub.remote.resources.ingredient.NutrientResource

data class NutritionResource(
    @SerializedName("caloricBreakdown")
    val caloricBreakdown: CaloricBreakdownResource? = CaloricBreakdownResource(),
    @SerializedName("flavonoids")
    val flavonoids: List<FlavonoidResource>? = listOf(),
    @SerializedName("ingredients")
    val ingredients: List<IngredientInformationResource>? = listOf(),
    @SerializedName("nutrients")
    val nutrients: List<NutrientResource>? = listOf(),
    @SerializedName("properties")
    val properties: List<PropertyResource>? = listOf(),
    @SerializedName("weightPerServing")
    val weightPerServing: WeightPerServingResource? = WeightPerServingResource()
)