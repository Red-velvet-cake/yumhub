package com.red_velvet.domain.usecases.recipes

import com.red_velvet.domain.models.recipes.CategoryEntity
import com.red_velvet.domain.repositories.RecipesRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val recipesRepository: RecipesRepository
) {

    suspend operator fun invoke(): List<CategoryEntity> {
        return recipesRepository.getCategoriesFromRemote()
    }

}