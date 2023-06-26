package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.models.SliderItemEntity
import com.red_velvet.yumhub.domain.repositories.RecipesRepository
import javax.inject.Inject

class GetHomeSliderImagesListUseCase @Inject constructor(
    private val recipesRepository: RecipesRepository
) {

    suspend operator fun invoke(): List<SliderItemEntity> {
        return recipesRepository.getHomeSliderImagesList()
    }
}