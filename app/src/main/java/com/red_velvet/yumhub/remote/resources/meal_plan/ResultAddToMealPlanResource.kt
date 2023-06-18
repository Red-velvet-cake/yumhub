package com.red_velvet.yumhub.remote.resources.meal_plan


import com.google.gson.annotations.SerializedName

data class ResultAddToMealPlanResource(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("status")
    val status: String? = null
)