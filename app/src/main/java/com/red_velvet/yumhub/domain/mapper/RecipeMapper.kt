package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.local.entities.RecipeEntity
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeInformationDto
import javax.inject.Inject

class RecipeMapper @Inject constructor() {
    fun map(recipe: RecipeInformationDto, genreList: List<RecipeInformationDto>): RecipeEntity {
        return RecipeEntity(
            id = recipe.id ?: 0,
            title = recipe.title ?: "",
            image = recipe.image ?: "",
            type = "",

        )
    }

}