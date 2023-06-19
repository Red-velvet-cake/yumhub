package com.red_velvet.domain.models.recipes


data class StepEntity(
    val equipmentEntities: List<EquipmentEntity>? = emptyList(),
    val lengthEntity:LengthEntity? = null,
    val number: Int?,
    val step: String?,
    val ingredientsEntity: List<IngredientsEntity>? = emptyList(),
)
