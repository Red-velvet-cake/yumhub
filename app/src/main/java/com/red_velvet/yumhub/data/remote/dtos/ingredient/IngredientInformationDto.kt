package com.red_velvet.yumhub.data.remote.dtos.ingredient


import com.google.gson.annotations.SerializedName
import com.red_velvet.yumhub.data.remote.dtos.NutritionDto

data class IngredientInformationDto(
    @SerializedName("aisle")
    val aisle: String? = null,
    @SerializedName("amount")
    val amount: Double? = 0.0,
    @SerializedName("categoryPath")
    val categoryPath: List<String?>? = null,
    @SerializedName("consistency")
    val consistency: String? = null,
    @SerializedName("estimatedCost")
    val estimatedCost: EstimatedCostDto? = null,
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("meta")
    val meta: List<Any?>? = null,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("nutrition")
    val nutrition: NutritionDto? = null,
    @SerializedName("original")
    val original: String? = null,
    @SerializedName("originalName")
    val originalName: String? = null,
    @SerializedName("possibleUnits")
    val possibleUnits: List<String?>? = null,
    @SerializedName("shoppingListUnits")
    val shoppingListUnits: List<String?>? = null,
    @SerializedName("unit")
    val unit: String? = "",
    @SerializedName("unitLong")
    val unitLong: String? = null,
    @SerializedName("unitShort")
    val unitShort: String? = null,
    @SerializedName("nutrients")
    val nutrients: List<NutrientDto>? = listOf(),
)