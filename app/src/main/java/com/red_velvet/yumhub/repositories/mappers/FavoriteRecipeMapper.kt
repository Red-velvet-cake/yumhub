package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.local.entities.FavoriteRecipeDto

fun FavoriteRecipeDto.toEntity(): RecipeEntity {
    return RecipeEntity(
        id = id,
        title = title,
        imageUrl = image,
        overview = overview
    )
}

fun List<FavoriteRecipeDto>.toEntityList(): List<RecipeEntity> {
    return map { it.toEntity() }
}

fun RecipeEntity.toFavoriteRecipeDto(): FavoriteRecipeDto {
    return FavoriteRecipeDto(
        id = id,
        title = title,
        image = imageUrl,
        overview = overview
    )
}