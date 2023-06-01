package com.red_velvet.yumhub.domain.mapper

import com.karrar.movieapp.domain.mappers.Mapper
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchDto
import com.red_velvet.yumhub.domain.models.IngredientSearch
import javax.inject.Inject


class IngredientSearchDtoMapper @Inject constructor() : Mapper<IngredientSearchDto, IngredientSearch> {
    override fun map(input: IngredientSearchDto): IngredientSearch {
        return IngredientSearch(
            id = input. ?: 0,
            actorName = input.name ?: "unknown",
            actorImage = BuildConfig.IMAGE_BASE_PATH + input.profilePath
        )
    }
}