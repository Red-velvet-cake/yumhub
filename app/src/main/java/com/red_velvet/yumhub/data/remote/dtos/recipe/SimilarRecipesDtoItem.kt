package com.red_velvet.yumhub.data.remote.dtos.recipe


import com.google.gson.annotations.SerializedName

data class SimilarRecipesDtoItem(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("imageType")
    val imageType: String? = null,
    @SerializedName("readyInMinutes")
    val readyInMinutes: Int? = null,
    @SerializedName("servings")
    val servings: Int? = null,
    @SerializedName("sourceUrl")
    val sourceUrl: String? = null,
    @SerializedName("title")
    val title: String? = null
)