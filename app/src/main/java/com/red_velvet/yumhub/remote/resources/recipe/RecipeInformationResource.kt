package com.red_velvet.yumhub.remote.resources.recipe


import com.google.gson.annotations.SerializedName
import com.red_velvet.yumhub.remote.resources.AnalyzedInstructionResource
import com.red_velvet.yumhub.remote.resources.ExtendedIngredientResource
import com.red_velvet.yumhub.remote.resources.NutritionResource
import com.red_velvet.yumhub.remote.resources.WinePairingResource

data class RecipeInformationResource(
    @SerializedName("aggregateLikes")
    val aggregateLikes: Int? = 0,
    @SerializedName("analyzedInstructions")
    val analyzedInstructions: List<AnalyzedInstructionResource>? = listOf(),
    @SerializedName("cheap")
    val cheap: Boolean? = false,
    @SerializedName("cookingMinutes")
    val cookingMinutes: Int? = 0,
    @SerializedName("creditsText")
    val creditsText: String? = "",
    @SerializedName("cuisines")
    val cuisines: List<String>? = listOf(),
    @SerializedName("dairyFree")
    val dairyFree: Boolean? = false,
    @SerializedName("diets")
    val diets: List<String>? = listOf(),
    @SerializedName("dishTypes")
    val dishTypes: List<String>? = listOf(),
    @SerializedName("gaps")
    val gaps: String? = "",
    @SerializedName("glutenFree")
    val glutenFree: Boolean? = false,
    @SerializedName("healthScore")
    val healthScore: Int? = 0,
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("image")
    val image: String? = "",
    @SerializedName("imageType")
    val imageType: String? = "",
    @SerializedName("license")
    val license: String? = "",
    @SerializedName("lowFodmap")
    val lowFodmap: Boolean? = false,
    @SerializedName("nutrition")
    val nutrition: NutritionResource? = NutritionResource(),
    @SerializedName("occasions")
    val occasions: List<Any>? = listOf(),
    @SerializedName("preparationMinutes")
    val preparationMinutes: Int? = 0,
    @SerializedName("pricePerServing")
    val pricePerServing: Double? = 0.0,
    @SerializedName("readyInMinutes")
    val readyInMinutes: Int? = 0,
    @SerializedName("servings")
    val servings: Int? = 0,
    @SerializedName("sourceName")
    val sourceName: String? = "",
    @SerializedName("sourceUrl")
    val sourceUrl: String? = "",
    @SerializedName("spoonacularSourceUrl")
    val spoonacularSourceUrl: String? = "",
    @SerializedName("summary")
    val summary: String? = "",
    @SerializedName("sustainable")
    val sustainable: Boolean? = false,
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("vegan")
    val vegan: Boolean? = false,
    @SerializedName("vegetarian")
    val vegetarian: Boolean? = false,
    @SerializedName("veryHealthy")
    val veryHealthy: Boolean? = false,
    @SerializedName("veryPopular")
    val veryPopular: Boolean? = false,
    @SerializedName("weightWatcherSmartPoints")
    val weightWatcherSmartPoints: Int? = 0,
    @SerializedName("extendedIngredients")
    val extendedIngredients: List<ExtendedIngredientResource> = emptyList(),
    @SerializedName("instructions")
    val instructions: String? = null,
    @SerializedName("originalId")
    val originalId: Any? = null,
    @SerializedName("winePairing")
    val winePairing: WinePairingResource? = null
)