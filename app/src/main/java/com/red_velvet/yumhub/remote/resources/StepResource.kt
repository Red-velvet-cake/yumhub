package com.red_velvet.yumhub.remote.resources


import com.google.gson.annotations.SerializedName

data class StepResource(
    @SerializedName("equipment")
    val equipment: List<com.red_velvet.yumhub.remote.resources.EquipmentResource> = emptyList(),
    @SerializedName("ingredients")
    val ingredients: List<com.red_velvet.yumhub.remote.resources.IngredientResource?>? = null,
    @SerializedName("length")
    val length: com.red_velvet.yumhub.remote.resources.LengthResource = com.red_velvet.yumhub.remote.resources.LengthResource(),
    @SerializedName("number")
    val number: Int? = null,
    @SerializedName("step")
    val step: String? = null
)