package com.red_velvet.yumhub.domain.mapper

import com.karrar.movieapp.domain.mappers.Mapper
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchResultDto
import com.red_velvet.yumhub.domain.models.IngredientSearch
import javax.inject.Inject


class IngredientSearchDtoMapper @Inject constructor() : Mapper<IngredientSearchResultDto, IngredientSearch> {
    override fun map(input: IngredientSearchResultDto): IngredientSearch {
        return IngredientSearch(
            id = input.id ?: 0, name = input.name ?: "", image = input.image ?: ""
        )
    }
}
