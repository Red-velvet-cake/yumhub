package com.red_velvet.yumhub.data.remote.dtos


import com.google.gson.annotations.SerializedName
import com.red_velvet.yumhub.data.remote.dtos.ingredient.NutrientDto

data class IngredientInformationDto(
    @SerializedName("amount")
    val amount: Double? = 0.0,
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("nutrients")
    val nutrients: List<NutrientDto>? = listOf(),
    @SerializedName("unit")
    val unit: String? = ""
)