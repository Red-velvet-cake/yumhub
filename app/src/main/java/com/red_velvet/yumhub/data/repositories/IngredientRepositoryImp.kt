package com.red_velvet.yumhub.data.repositories

import com.red_velvet.yumhub.data.remote.FoodService
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientInformationDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchResultDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSubstituteDto
import javax.inject.Inject

class IngredientRepositoryImp @Inject constructor(
    private val foodService: FoodService,
) : IngredientRepository {
    override suspend fun searchIngredient(
        query: String,
        sort: String?,
        intolerances: String?,
        number: Int?
    ): IngredientSearchDto {
        val response = foodService.searchIngredients(
            query = query,
            sort = sort,
        )
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getIngredientInformation(
        id: Int,
        amount: Int?,
        unit: String?
    ): IngredientInformationDto {
        val response = foodService.getIngredientInformation(id)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }

    }

    override suspend fun getSubstitutesIngredient(ingredientName: String): IngredientSubstituteDto {
        val response = foodService.getSubstitutesIngredient(ingredientName = ingredientName)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }
}