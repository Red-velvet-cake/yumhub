package com.red_velvet.yumhub.domain.usecases
import com.red_velvet.yumhub.data.repositories.IngredientRepository
import com.red_velvet.yumhub.domain.mapper.IngredientSearchDtoMapper
import com.red_velvet.yumhub.domain.models.IngredientSearch
import javax.inject.Inject

class SearchIngredientUseCase @Inject constructor(
    private val ingredientRepository: IngredientRepository,
    private  val  ingredientSearchDtoMapper: IngredientSearchDtoMapper
) {
    suspend operator fun  invoke(
        query: String,
        intolerances:String?,
        sort :String?,
        number: Int)
    : List<IngredientSearch>{
        val response =ingredientRepository.searchIngredient(
               query =query,
                sort =sort,
                intolerances = intolerances,
                number =number )
        return response.results?.map {
            ingredientSearchDtoMapper.map(it!!)
        }?.toList() ?: throw Throwable()
    }
}