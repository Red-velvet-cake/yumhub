package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.local.entities.RecipeEntity
import com.red_velvet.yumhub.domain.models.recipes.Recipe
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero

fun RecipeEntity.toModel(): Recipe {
    return Recipe(
        id = this.id.orZero(),
        title = this.title.orEmpty(),
        image = this.image.orEmpty(),
        type = this.type.orEmpty()
    )
}