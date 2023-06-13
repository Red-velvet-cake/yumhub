package com.red_velvet.yumhub.remote.resources


import com.google.gson.annotations.SerializedName

data class StepResource(
    @SerializedName("equipment")
    val equipment: List<EquipmentResource> = emptyList(),
    @SerializedName("ingredients")
    val ingredients: List<IngredientResource?>? = null,
    @SerializedName("length")
    val length: LengthResource = LengthResource(),
    @SerializedName("number")
    val number: Int? = null,
    @SerializedName("step")
    val step: String? = null
)