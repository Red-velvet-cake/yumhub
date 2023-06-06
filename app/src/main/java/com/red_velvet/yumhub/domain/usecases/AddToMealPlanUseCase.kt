package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.data.repositories.MealRepository
import com.red_velvet.yumhub.domain.models.MealPlan
import javax.inject.Inject

class AddToMealPlanUseCase @Inject constructor(
    private val mealRepository: MealRepository,
) {
    suspend operator fun invoke(
        addToMealPlan: MealPlan,
        username: String,
        hash: String,
    ) {
        return mealRepository
            .addToMealPlan(addToMealPlan, username, hash)
    }
}