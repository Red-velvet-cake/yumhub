package com.red_velvet.yumhub.domain.models.recipes



data class StepEntity(
    val equipmentEntities: List<EquipmentEntity>,
    val lengthEntity: LengthEntity,
    val number: Int,
    val step: String,
    val ingredientsEntity: List<IngredientsEntity>
)
