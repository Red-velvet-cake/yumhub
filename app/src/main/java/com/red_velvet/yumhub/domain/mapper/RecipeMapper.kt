package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.local.entities.RecipeEntity
import com.red_velvet.yumhub.domain.models.recipes.Recipe

fun RecipeEntity.toModel(): Recipe {
    return Recipe(
        id = this.id ?: 0,
        title = this.title ?: "",
        image = this.image ?: "",
        type = this.type ?: ""
    )
}