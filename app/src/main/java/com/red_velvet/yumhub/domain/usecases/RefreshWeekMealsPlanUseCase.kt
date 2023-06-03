package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.data.repositories.MealRepository
import javax.inject.Inject

class RefreshWeekMealsPlanUseCase @Inject constructor(
    private val mealRepository: MealRepository,
) {
    suspend operator fun invoke(
        date: String,
        username: String,
        hash: String,
    ) {
        mealRepository
            .refreshWeekMealsPlan(date, username, hash)
    }
}