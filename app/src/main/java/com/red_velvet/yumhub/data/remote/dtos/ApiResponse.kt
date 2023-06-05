package com.red_velvet.yumhub.data.remote.dtos


import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("code")
    val code: Int? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("status")
    val status: String? = null
)