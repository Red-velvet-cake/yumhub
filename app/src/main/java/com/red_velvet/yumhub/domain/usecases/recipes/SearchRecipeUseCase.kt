package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.data.repositories.RecipesRepositoryImpl
import com.red_velvet.yumhub.domain.mapper.toModel
import com.red_velvet.yumhub.domain.models.recipes.RecipeInformation
import javax.inject.Inject

class SearchRecipeUseCase  @Inject constructor(
   private  val recipesRepositoryImpl : RecipesRepositoryImpl
        ) {
    suspend operator fun invoke(query: String,sort:String,sortDirection:String): List<RecipeInformation> {
        return recipesRepositoryImpl
            .searchRecipe(
                query = query,
                sort=sort,
                sortDirection=sortDirection
            ).results?.map {
                it!!.toModel()
            } ?: throw Exception()
    }
}