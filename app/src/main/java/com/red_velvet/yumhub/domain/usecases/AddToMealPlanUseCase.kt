package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.data.local.entities.MealPlanEntity
import com.red_velvet.yumhub.data.repositories.MealRepository
import com.red_velvet.yumhub.domain.mapper.toMealPlanDto
import javax.inject.Inject

class AddToMealPlanUseCase @Inject constructor(
    private val mealRepository: MealRepository,
) {

    suspend operator fun invoke(
        addToMealPlan: MealPlanEntity,
        username: String,
        hash: String,

        ){
        return mealRepository
            .addToMealPlan(addToMealPlan.toMealPlanDto(), username, hash)
    }
}