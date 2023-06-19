package com.red_velvet.repository.resources.ingredient


import com.google.gson.annotations.SerializedName

data class IngredientSubstituteResource(
    @SerializedName("ingredient")
    val ingredient: String? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("substitutes")
    val substitutes: List<String?>? = null
)