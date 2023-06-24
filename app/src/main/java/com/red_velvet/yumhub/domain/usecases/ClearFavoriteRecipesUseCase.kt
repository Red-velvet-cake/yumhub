package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.repositories.UserRepository
import javax.inject.Inject

class ClearFavoriteRecipesUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke() {
        userRepository.clearFavoriteRecipes()
    }
}