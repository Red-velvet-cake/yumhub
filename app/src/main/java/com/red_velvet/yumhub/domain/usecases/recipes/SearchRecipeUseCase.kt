package com.red_velvet.yumhub.domain.usecases.recipes

import androidx.paging.PagingData
import androidx.paging.map
import com.red_velvet.yumhub.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.yumhub.repositories.RecipesRepositoryImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchRecipeUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepositoryImpl,
    private val getMinuteAsHourAndMinutes: GetMinuteAsHourAndMinutes,
    private val getIngredientCountUseCase: GetIngredientCountUseCase
) {
    operator fun invoke(
        query: String,
        sort: String,
        sortDirection: String
    ): Flow<PagingData<SearchRecipeEntity>> {

        return recipesRepositoryImpl.searchRecipe(
            query = query,
            sort = sort,
            sortDirection = sortDirection
        ).map { pagingData ->
            pagingData.map { recipeEntity ->
                recipeEntity.copy(
                    readyInMinutes = getMinuteAsHourAndMinutes.invoke(recipeEntity.readyInMinutes),
                    ingredientNumber = getIngredientCountUseCase.invoke(recipeEntity.analyzedInstructions)
                )
            }
        }
    }
}