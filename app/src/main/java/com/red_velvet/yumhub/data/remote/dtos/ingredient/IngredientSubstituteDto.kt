package com.red_velvet.yumhub.data.remote.dtos.ingredient


import com.google.gson.annotations.SerializedName

data class IngredientSubstituteDto(
    @SerializedName("ingredient")
    val ingredient: String? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("substitutes")
    val substitutes: List<String?>? = null
)