package com.red_velvet.domain.usecases

import com.red_velvet.domain.models.MealPlanEntity
import com.red_velvet.domain.repositories.MealRepository
import javax.inject.Inject

class AddToMealPlanUseCase @Inject constructor(
    private val mealRepository: MealRepository,
) {
    suspend operator fun invoke(
        addToMealPlan: MealPlanEntity,
        username: String,
        hash: String,
    ) {
        mealRepository.addToMealPlan(addToMealPlan, username, hash)
    }
}