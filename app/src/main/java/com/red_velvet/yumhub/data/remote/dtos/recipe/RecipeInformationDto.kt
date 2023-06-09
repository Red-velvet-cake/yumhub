package com.red_velvet.yumhub.data.remote.dtos.recipe


import com.google.gson.annotations.SerializedName
import com.red_velvet.yumhub.data.remote.dtos.AnalyzedInstructionDto
import com.red_velvet.yumhub.data.remote.dtos.ExtendedIngredientDto
import com.red_velvet.yumhub.data.remote.dtos.WinePairingDto

data class RecipeInformationDto(
    @SerializedName("aggregateLikes")
    val aggregateLikes: Int? = null,
    @SerializedName("analyzedInstructions")
    val analyzedInstructions: List<AnalyzedInstructionDto> = emptyList(),
    @SerializedName("cheap")
    val cheap: Boolean? = null,
    @SerializedName("cookingMinutes")
    val cookingMinutes: Int? = null,
    @SerializedName("creditsText")
    val creditsText: String? = null,
    @SerializedName("cuisines")
    val cuisines: List<String> = emptyList(),
    @SerializedName("dairyFree")
    val dairyFree: Boolean? = null,
    @SerializedName("diets")
    val diets: List<String> = emptyList(),
    @SerializedName("dishTypes")
    val dishTypes: List<String> = emptyList(),
    @SerializedName("extendedIngredients")
    val extendedIngredients: List<ExtendedIngredientDto> = emptyList(),
    @SerializedName("gaps")
    val gaps: String? = null,
    @SerializedName("glutenFree")
    val glutenFree: Boolean? = null,
    @SerializedName("healthScore")
    val healthScore: Int? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("imageType")
    val imageType: String? = null,
    @SerializedName("instructions")
    val instructions: String? = null,
    @SerializedName("license")
    val license: String? = null,
    @SerializedName("lowFodmap")
    val lowFodmap: Boolean? = null,
    @SerializedName("occasions")
    val occasions: List<Any?>? = null,
    @SerializedName("originalId")
    val originalId: Any? = null,
    @SerializedName("preparationMinutes")
    val preparationMinutes: Int? = null,
    @SerializedName("pricePerServing")
    val pricePerServing: Double? = null,
    @SerializedName("readyInMinutes")
    val readyInMinutes: Int? = null,
    @SerializedName("servings")
    val servings: Int? = null,
    @SerializedName("sourceName")
    val sourceName: String? = null,
    @SerializedName("sourceUrl")
    val sourceUrl: String? = null,
    @SerializedName("spoonacularSourceUrl")
    val spoonacularSourceUrl: String? = null,
    @SerializedName("summary")
    val summary: String? = null,
    @SerializedName("sustainable")
    val sustainable: Boolean? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("vegan")
    val vegan: Boolean? = null,
    @SerializedName("vegetarian")
    val vegetarian: Boolean? = null,
    @SerializedName("veryHealthy")
    val veryHealthy: Boolean? = null,
    @SerializedName("veryPopular")
    val veryPopular: Boolean? = null,
    @SerializedName("weightWatcherSmartPoints")
    val weightWatcherSmartPoints: Int? = null,
    @SerializedName("winePairing")
    val winePairing: WinePairingDto? = null
) {

}