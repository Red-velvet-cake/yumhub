package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.data.remote.FoodService
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchDto
import com.red_velvet.yumhub.data.repositories.IngredientRepository
import com.red_velvet.yumhub.domain.mapper.IngredientInformationMapper
import retrofit2.http.Query
import javax.inject.Inject

class SearchIngredientUseCase @Inject constructor(
    private val ingredientRepository: IngredientRepository,
    private  val  ingredientInformationMapper: IngredientInformationMapper
) {
    suspend operator fun  invoke(
        query: String,
        intolerances:String?,
        sort :String?,
        number: Int)
    : IngredientSearchDto {
        val response =ingredientRepository.searchIngredient(
               query =query,
                sort =sort,
                intolerances = intolerances,
                number =number )
        return ingredientInformationMapper.map(response)

    }
}