package com.red_velvet.yumhub.remote.dtos


import com.google.gson.annotations.SerializedName

data class LengthDto(
    @SerializedName("number")
    val number: Int? = null,
    @SerializedName("unit")
    val unit: String? = null
)