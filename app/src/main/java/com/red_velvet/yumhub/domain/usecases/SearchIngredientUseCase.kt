package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.data.remote.FoodService
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchDto
import com.red_velvet.yumhub.data.repositories.IngredientRepository
import retrofit2.http.Query
import javax.inject.Inject

class SearchIngredientUseCase @Inject constructor(
    private val ingredientRepository: IngredientRepository,
) {
    suspend operator fun  invoke(
        query: String,
        intolerances:String?,
        sort :String?,
        number: Int)
    : IngredientSearchDto {
        return ingredientRepository
            .searchIngredient(
                query =query,
                sort =sort,
                intolerances = intolerances,
                number =number ).toModel()

    }
}