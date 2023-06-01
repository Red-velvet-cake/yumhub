package com.red_velvet.yumhub.data.repositories

import com.red_velvet.yumhub.data.remote.FoodService
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientInformationDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchResultDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSubstituteDto
import retrofit2.Response
import javax.inject.Inject

class IngredientRepositoryImp @Inject constructor(
    private val foodService: FoodService,) :IngredientRepository {
    override suspend fun searchIngredient(
        query: String,
        sort: String?,
        intolerances: String?,
        number: Int?
    ): Response<IngredientSearchDto>{
      return  foodService.searchIngredients(
          query=query,
          sort=sort,
          intolerances=  intolerances,
          number=  number)
    }

    override suspend fun getIngredientInformation(
        id: Int,
        amount: Int,
        unit: String?
    ): Response<IngredientInformationDto> {
       return  foodService.getIngredientInformation(
           id=id ,
           amount= amount,
           unit= unit)
    }

    override suspend fun getSubstitutesIngredient(ingredientName: String): Response<IngredientSubstituteDto> {
        return  foodService.getSubstitutesIngredient(ingredientName=ingredientName)
    }
}