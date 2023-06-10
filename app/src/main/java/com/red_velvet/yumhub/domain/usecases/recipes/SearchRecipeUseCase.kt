package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.domain.mapper.toRecipeSearch
import com.red_velvet.yumhub.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.yumhub.repositories.RecipesRepositoryImpl
import javax.inject.Inject

class SearchRecipeUseCase  @Inject constructor(
   private  val recipesRepositoryImpl : RecipesRepositoryImpl
        ) {
    suspend operator fun invoke(query: String,sort:String): List<SearchRecipeEntity> {
        return recipesRepositoryImpl
            .searchRecipe(
                query = query,
                sort=sort
            ).results?.map {
                it!!.toRecipeSearch()
            } ?: throw Exception()
    }
}