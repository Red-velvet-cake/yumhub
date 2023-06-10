package com.red_velvet.yumhub.remote.dtos.meal_plan


import com.google.gson.annotations.SerializedName

data class Value(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("imageType")
    val imageType: String? = null,
    @SerializedName("servings")
    val servings: Int? = null,
    @SerializedName("title")
    val title: String? = null
)