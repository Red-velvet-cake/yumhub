package com.red_velvet.yumhub.remote.dtos.recipe


import com.google.gson.annotations.SerializedName

data class RecipeSearchResultResource(
    @SerializedName("aggregateLikes")
    val aggregateLikes: Int? = 0,
    @SerializedName("analyzedInstructions")
    val analyzedInstructions: List<com.red_velvet.yumhub.remote.dtos.AnalyzedInstructionDto>? = listOf(),
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
    val nutrition: com.red_velvet.yumhub.remote.dtos.NutritionDto? = com.red_velvet.yumhub.remote.dtos.NutritionDto(),
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
    val weightWatcherSmartPoints: Int? = 0
)