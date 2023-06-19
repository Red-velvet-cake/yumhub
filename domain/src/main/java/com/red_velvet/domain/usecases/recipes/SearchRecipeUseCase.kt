package com.red_velvet.domain.usecases.recipes
import com.red_velvet.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.domain.repositories.RecipesRepository
import javax.inject.Inject

class SearchRecipeUseCase  @Inject constructor(
   private  val recipesRepository: RecipesRepository
        ) {
    suspend operator fun invoke(
        query: String,
        sort: String,
        sortDirection: String
    ): List<SearchRecipeEntity> {
        return recipesRepository
            .searchRecipe(
                query = query,
                sort = sort,
                sortDirection = sortDirection
            )
    }
}

