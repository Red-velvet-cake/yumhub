package com.red_velvet.repository.resources.meal_plan


import com.google.gson.annotations.SerializedName

data class ValueResource(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("imageType")
    val imageType: String? = null,
    @SerializedName("servings")
    val servings: Int? = null,
    @SerializedName("title")
    val title: String? = null
)