package com.red_velvet.yumhub.remote.resources.meal_plan


import com.google.gson.annotations.SerializedName

data class ValueResource(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("imageType")
    val imageType: String? = "",
    @SerializedName("servings")
    val servings: Int? = 0,
    @SerializedName("title")
    val title: String? = ""
)