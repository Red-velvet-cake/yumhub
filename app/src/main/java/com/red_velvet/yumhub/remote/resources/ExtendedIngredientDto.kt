package com.red_velvet.yumhub.remote.resources


import com.google.gson.annotations.SerializedName

data class ExtendedIngredientDto(
    @SerializedName("aisle")
    val aisle: String? = null,
    @SerializedName("amount")
    val amount: Double? = null,
    @SerializedName("consistency")
    val consistency: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("measures")
    val measures: com.red_velvet.yumhub.remote.resources.MeasuresDto? = null,
    @SerializedName("meta")
    val meta: List<String?>? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("nameClean")
    val nameClean: String? = null,
    @SerializedName("original")
    val original: String? = null,
    @SerializedName("originalName")
    val originalName: String? = null,
    @SerializedName("unit")
    val unit: String? = null
)