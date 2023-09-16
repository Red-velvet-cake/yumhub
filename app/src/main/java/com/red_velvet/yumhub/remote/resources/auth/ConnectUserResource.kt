package com.red_velvet.yumhub.remote.resources.auth


import com.google.gson.annotations.SerializedName

data class ConnectUserResource(
    @SerializedName("hash")
    val hash: String? = null,
    @SerializedName("spoonacularPassword")
    val spoonacularPassword: String? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("username")
    val username: String? = null
)