package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.domain.repositories.UserRepository
import javax.inject.Inject

class SaveFavoriteRecipeUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(recipe: RecipeEntity) {
        userRepository.saveFavoriteRecipe(recipe)
    }
}