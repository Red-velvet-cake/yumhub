package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchResultDto
import com.red_velvet.yumhub.domain.models.IngredientSearch

  fun IngredientSearchResultDto.toIngredientSearchResultDtoMapper(): IngredientSearch {
        return IngredientSearch(
            id = this.id ?: 0,
            name = this.name ?: "",
            image = this.image ?: ""
        )
    }

