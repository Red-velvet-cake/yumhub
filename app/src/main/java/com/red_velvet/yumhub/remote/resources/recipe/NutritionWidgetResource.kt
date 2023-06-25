package com.red_velvet.yumhub.remote.resources.recipe


import com.google.gson.annotations.SerializedName

data class NutritionWidgetResource(
    @SerializedName("bad")
    val bad: List<NutritionalInfoResource?>? = null,
    @SerializedName("calories")
    val calories: String? = null,
    @SerializedName("carbs")
    val carbs: String? = null,
    @SerializedName("fat")
    val fat: String? = null,
    @SerializedName("good")
    val good: List<NutritionalInfoResource?>? = null,
    @SerializedName("protein")
    val protein: String? = null
)