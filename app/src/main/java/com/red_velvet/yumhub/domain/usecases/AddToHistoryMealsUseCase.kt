package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.models.HistoryMealEntity
import com.red_velvet.yumhub.domain.repositories.MealRepository
import javax.inject.Inject

class AddToHistoryMealsUseCase @Inject constructor(
    private val mealRepository: MealRepository,
    val getHistoryMealsUsecase: GetHistoryMealsUsecase,

    ) {
    suspend operator fun invoke(
        historyMealEntity: HistoryMealEntity
    ) {
        val historyList = getHistoryMealsUsecase().toMutableList()
        if (historyList.contains(historyMealEntity)) {
            raiseItemToTopIfFound(historyList, historyMealEntity)
        } else {
            historyList.add(historyMealEntity)
            mealRepository.addToHistoryMeals(historyList)
        }
    }

    private suspend fun raiseItemToTopIfFound(
        historyList: MutableList<HistoryMealEntity>, historyMealEntity: HistoryMealEntity
    ) {
        historyList.remove(historyMealEntity)
        historyList.add(historyMealEntity)
//        historyList.sortedBy { it.date }
        mealRepository.addToHistoryMeals(historyList)
    }
}