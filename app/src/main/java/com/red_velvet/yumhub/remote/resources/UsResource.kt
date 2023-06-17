package com.red_velvet.yumhub.remote.resources


import com.google.gson.annotations.SerializedName

data class UsResource(
    @SerializedName("amount")
    val amount: Double? = null,
    @SerializedName("unitLong")
    val unitLong: String? = null,
    @SerializedName("unitShort")
    val unitShort: String? = null
)