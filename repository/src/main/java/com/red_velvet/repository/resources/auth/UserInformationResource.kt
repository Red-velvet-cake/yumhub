package com.red_velvet.repository.resources.auth


import com.google.gson.annotations.SerializedName

data class UserInformationResource(
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("firstName")
    val firstName: String? = null,
    @SerializedName("lastName")
    val lastName: String? = null,
    @SerializedName("username")
    val username: String? = null
)