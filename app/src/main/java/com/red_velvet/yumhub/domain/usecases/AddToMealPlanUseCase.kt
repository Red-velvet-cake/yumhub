package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.data.remote.dtos.meal_plan.AddMealDto
import com.red_velvet.yumhub.data.repositories.MealRepositoryImpl
import com.red_velvet.yumhub.domain.mapper.toResultAddToMealPlanMapper
import com.red_velvet.yumhub.domain.models.ResultAddToMealPlan
import javax.inject.Inject

class AddToMealPlanUseCase @Inject constructor(
    private val repository: MealRepositoryImpl
) {

    suspend operator fun invoke(
        addToMeal: AddMealDto,
        username: String,
        hash: String
    ): ResultAddToMealPlan {
        return repository.addToMealPlan(addToMeal, username, hash).toResultAddToMealPlanMapper()
    }

}