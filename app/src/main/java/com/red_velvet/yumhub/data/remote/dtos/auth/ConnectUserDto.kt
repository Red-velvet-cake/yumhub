package com.red_velvet.yumhub.data.remote.dtos.auth


import com.google.gson.annotations.SerializedName

data class ConnectUserDto(
    @SerializedName("hash")
    val hash: String? = null,
    @SerializedName("spoonacularPassword")
    val spoonacularPassword: String? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("username")
    val username: String? = null
)