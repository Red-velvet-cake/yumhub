package com.red_velvet.repository.resources


import com.google.gson.annotations.SerializedName

data class StepResource(
    @SerializedName("equipment")
    val equipment: List<com.red_velvet.repository.resources.EquipmentResource> = emptyList(),
    @SerializedName("ingredients")
    val ingredients: List<com.red_velvet.repository.resources.IngredientResource?>? = null,
    @SerializedName("length")
    val length: com.red_velvet.repository.resources.LengthResource = com.red_velvet.repository.resources.LengthResource(),
    @SerializedName("number")
    val number: Int? = null,
    @SerializedName("step")
    val step: String? = null
)