package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeSearchDto
import com.red_velvet.yumhub.data.repositories.RecipesRepositoryImpl
import com.red_velvet.yumhub.domain.mapper.toIngredientSubstitute
import com.red_velvet.yumhub.domain.models.IngredientSubstitutes

class SearchRecipeUseCase (
   private  val recipesRepositoryImpl : RecipesRepositoryImpl
        ) {
    suspend operator fun invoke(query: String,sort:String): RecipeSearchDto {
        return recipesRepositoryImpl
            .searchRecipe(
                query = query,
                sort=sort
            ).toIngredientSubstitute()
    }
}