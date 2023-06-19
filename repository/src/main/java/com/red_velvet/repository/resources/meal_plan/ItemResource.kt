package com.red_velvet.repository.resources.meal_plan


import com.google.gson.annotations.SerializedName

data class ItemResource(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("position")
    val position: Int? = null,
    @SerializedName("slot")
    val slot: Int? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("value")
    val valueResource: com.red_velvet.repository.resources.meal_plan.ValueResource? = null
)