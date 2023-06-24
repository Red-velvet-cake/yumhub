package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.models.HistoryMealEntity
import com.red_velvet.yumhub.domain.repositories.MealRepository
import javax.inject.Inject

class GetHistoryMealsUsecase @Inject constructor(
    private val mealRepository: MealRepository,
) {
    operator fun invoke(): List<HistoryMealEntity> {
        return mealRepository.getHistoryMeals()
    }
}