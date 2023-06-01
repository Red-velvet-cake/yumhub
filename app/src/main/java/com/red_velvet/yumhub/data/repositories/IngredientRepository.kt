package com.red_velvet.yumhub.data.repositories

import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientInformationDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchResultDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSubstituteDto

interface IngredientRepository {

    suspend fun searchIngredient(
        query: String,
        sort: String?,
        intolerances: String?,
        number :Int?
    ):IngredientSearchDto

    suspend fun getIngredientInformation(
        id: Int,
        amount: Int,
        unit: String?,

    ): IngredientInformationDto

    suspend fun getSubstitutesIngredient(
        ingredientName:String
    ):IngredientSubstituteDto
}