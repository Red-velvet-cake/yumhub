package com.red_velvet.yumhub.domain.usecases.recipes
import com.red_velvet.yumhub.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.yumhub.repositories.RecipesRepositoryImpl
import javax.inject.Inject

class SearchRecipeUseCase  @Inject constructor(
   private  val recipesRepositoryImpl : RecipesRepositoryImpl,
   private  val getMinutAsHourAndMinuts:GetMinutAsHourAndMinuts,
   private val getIngredientCountUseCase:GetIngredientCountUseCase
        ) {
    suspend operator fun invoke(
        query: String,
        sort: String,
        sortDirection: String
    ): List<SearchRecipeEntity> {
        return recipesRepositoryImpl
            .searchRecipe(
                query = query,
                sort = sort,
                sortDirection = sortDirection
            ).map {
                it.copy(
                    readyInMinutes =getMinutAsHourAndMinuts.invoke(it.readyInMinutes),
                    ingredientNumber = getIngredientCountUseCase.invoke(it.analyzedInstructions)
                )
            }
    }
}

