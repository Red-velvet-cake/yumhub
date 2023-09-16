package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.models.DayPlannedMealsEntity
import com.red_velvet.yumhub.domain.repositories.MealRepository
import com.red_velvet.yumhub.repositories.datasources.SharedPreferenceService
import javax.inject.Inject

class GetWeekMealsPlanUseCase @Inject constructor(
    private val mealRepository: MealRepository,
    private val sharedPreferenceService: SharedPreferenceService
) {
    suspend operator fun invoke(date: String): List<DayPlannedMealsEntity> {
        return mealRepository.getWeeklyPlannedMeals(
            username = sharedPreferenceService.getUserName() ?: "",
            hash = sharedPreferenceService.getHash() ?: "",
            date = date
        )
    }
}