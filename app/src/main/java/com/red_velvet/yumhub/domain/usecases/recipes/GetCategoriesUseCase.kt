package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.domain.models.recipes.CategoryEntity
import com.red_velvet.yumhub.domain.repositories.RecipesRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val recipesRepository: RecipesRepository
) {

    suspend operator fun invoke(): List<CategoryEntity> {
        return recipesRepository.getCategoriesFromRemote().shuffled()
    }

}