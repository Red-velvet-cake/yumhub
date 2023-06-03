package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchResultDto
import com.red_velvet.yumhub.domain.models.IngredientSearch

  fun IngredientSearchResultDto.toIngredientSearchResult(): IngredientSearch {
        return IngredientSearch(
            id = id ?: 0,
            name = name ?: "",
            image = image ?: ""
        )
    }

