package com.red_velvet.yumhub.ui.home

import com.red_velvet.yumhub.domain.models.SliderItemEntity

data class HomeSliderItemUiState(
    val imageResource: Int
)

fun List<SliderItemEntity>.toUiState(): List<HomeSliderItemUiState> {
    return this.map {
        HomeSliderItemUiState(
            imageResource = it.imageResource
        )
    }
}