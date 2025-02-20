package com.red_velvet.yumhub.domain.repositories

import com.red_velvet.yumhub.domain.models.IngredientSearchEntity
import com.red_velvet.yumhub.domain.models.IngredientSubstitutesEntity
import com.red_velvet.yumhub.domain.models.ingredientInformation.IngredientInformationEntity

interface IngredientRepository {

    suspend fun searchIngredient(
        query: String,
        sort: String? = "asc",
        intolerances: String? = "",
        number: Int? = 1
    ): List<IngredientSearchEntity>

    suspend fun getIngredientInformation(
        id: Int,
        amount: Int? = null,
        unit: String? = "",
    ): IngredientInformationEntity

    suspend fun getSubstitutesIngredient(
        ingredientName: String
    ): IngredientSubstitutesEntity
}