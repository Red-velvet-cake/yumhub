package com.red_velvet.yumhub.data.repositories

import com.red_velvet.yumhub.data.remote.FoodService
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientInformationDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchResultDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSubstituteDto
import javax.inject.Inject

class IngredientRepositoryImp @Inject constructor(
    private val foodService: FoodService,) :IngredientRepository {
    override suspend fun searchIngredient(
        query: String,
        sort: String?,
        intolerances: String?,
        number: Int?
    ): IngredientSearchDto{
      return  foodService.searchIngredients(
          query=query,
          sort=sort,
          intolerances=  intolerances,
          number=  number).body()!!
    }

    override suspend fun getIngredientInformation(
        id: Int,
        amount: Int,
        unit: String?
    ): IngredientInformationDto {
       return  foodService.getIngredientInformation(
           id=id ,
           amount= amount,
           unit= unit).body()!!
    }

    override suspend fun getSubstitutesIngredient(ingredientName: String): IngredientSubstituteDto {
        return  foodService.getSubstitutesIngredient(ingredientName=ingredientName).body()!!
    }
}