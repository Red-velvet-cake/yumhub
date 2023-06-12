package com.red_velvet.yumhub.remote.resources.meal_plan


import com.google.gson.annotations.SerializedName

data class AddMealResource(
    @SerializedName("date")
    val date: Int? = 0,
    @SerializedName("position")
    val position: Int? = 0,
    @SerializedName("slot")
    val slot: Int? = 0,
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("value")
    val valueResource: com.red_velvet.yumhub.remote.resources.meal_plan.ValueResource? = com.red_velvet.yumhub.remote.resources.meal_plan.ValueResource()
)