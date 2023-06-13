package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.mapper.toMealPlanDto
import com.red_velvet.yumhub.domain.repositories.MealRepository
import com.red_velvet.yumhub.local.entities.MealPlanLocalDto
import javax.inject.Inject

class AddToMealPlanUseCase @Inject constructor(
    private val mealRepository: MealRepository,
) {
    suspend operator fun invoke(
        addToMealPlan: MealPlanLocalDto,
        username: String,
        hash: String,
    ) {
        mealRepository.addToMealPlan(addToMealPlan.toMealPlanDto(), username, hash)
    }
}