package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.models.MealPlanEntity
import com.red_velvet.yumhub.domain.repositories.MealRepository
import javax.inject.Inject

class AddToMealPlanUseCase @Inject constructor(
    private val mealRepository: MealRepository,
    private val getUserNameUseCase: GetUserNameUseCase,
    private val getHashUseCase: GetHashUseCase
) {
    suspend operator fun invoke(
        addToMealPlan: MealPlanEntity
    ) {
        val userName = getUserNameUseCase()
        val hash = getHashUseCase()
        mealRepository.addToMealPlan(addToMealPlan, userName, hash)
    }
}