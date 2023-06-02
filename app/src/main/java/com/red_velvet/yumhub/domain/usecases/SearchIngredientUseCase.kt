package com.red_velvet.yumhub.domain.usecases
import com.red_velvet.yumhub.data.repositories.IngredientRepository
import com.red_velvet.yumhub.domain.mapper.toIngredientSearchResultDtoMapper
import com.red_velvet.yumhub.domain.models.IngredientSearch
import java.lang.Exception
import javax.inject.Inject

class SearchIngredientUseCase @Inject constructor(
    private val ingredientRepository: IngredientRepository,
) {
    suspend operator fun  invoke(
        query: String,
        intolerances:String?,
        sort :String?,
        number: Int)
    : List<IngredientSearch>{
        return ingredientRepository.searchIngredient(
               query =query,
                sort =sort,
                intolerances = intolerances,
                number =number ).results?.map {
                    it!!.toIngredientSearchResultDtoMapper()
        }?: throw Exception()
    }
}