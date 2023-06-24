package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.models.HistoryMealEntity
import com.red_velvet.yumhub.domain.repositories.MealRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class AddToHistoryMealsUseCase @Inject constructor(
    private val mealRepository: MealRepository,
    private val getHistoryMealsUsecase: GetHistoryMealsUsecase,
) {
    suspend operator fun invoke(historyMealEntity: HistoryMealEntity) {
        val historyList = getHistoryMealsUsecase().first().toMutableList()
        historyList.find { it.id == historyMealEntity.id }?.let {
            historyList.remove(it)
            mealRepository.deleteFromHistoryMeals(it.id)
        }
        addToHistory(historyList, historyMealEntity)
    }

    private suspend fun addToHistory(
        historyList: MutableList<HistoryMealEntity>, historyMealEntity: HistoryMealEntity
    ) {
        historyMealEntity.viewedAt = System.currentTimeMillis()
        historyList.add(0, historyMealEntity)
        mealRepository.addToHistoryMeals(historyList)
    }
}
