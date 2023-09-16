package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.domain.models.HistoryMealEntity
import com.red_velvet.yumhub.domain.models.recipes.RecipeInformationEntity
import com.red_velvet.yumhub.domain.repositories.RecipesRepository
import com.red_velvet.yumhub.domain.usecases.AddToHistoryMealsUseCase
import javax.inject.Inject

class GetRecipeInformationUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository,
    private val addToHistoryMealsUseCase: AddToHistoryMealsUseCase,
) {

    suspend operator fun invoke(
        id: Int
    ): RecipeInformationEntity {
        return recipesRepositoryImpl.getRecipeInformation(id).also {
            addToHistoryMealsUseCase(it.toHistoryMealEntity())
        }
    }
}

private fun RecipeInformationEntity.toHistoryMealEntity(): HistoryMealEntity {
    return HistoryMealEntity(
        id = this.id,
        title = this.title,
        image = this.image,
        description = this.description,
        viewedAt = 0
    )
}