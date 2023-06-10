package com.red_velvet.yumhub.remote.dtos.auth


import com.google.gson.annotations.SerializedName

data class UserInformationDto(
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("firstName")
    val firstName: String? = null,
    @SerializedName("lastName")
    val lastName: String? = null,
    @SerializedName("username")
    val username: String? = null
)