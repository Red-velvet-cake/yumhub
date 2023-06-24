package com.red_velvet.yumhub.domain.usecases

import android.util.Log
import com.red_velvet.yumhub.domain.models.HistoryMealEntity
import com.red_velvet.yumhub.domain.repositories.MealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

//class AddToHistoryMealsUseCase @Inject constructor(
//    private val mealRepository: MealRepository,
//    val getHistoryMealsUsecase: GetHistoryMealsUsecase,
//) {
//    suspend operator fun invoke(
//        historyMealEntity: HistoryMealEntity
//    ) {
//        var historyList = getHistoryMealsUsecase()
//        if (historyList.contains(historyMealEntity)) {
//            raiseItemToTopIfFound(historyList, historyMealEntity)
//        } else {
//            addToHistory(historyList, historyMealEntity)
//        }
//    }
//
//    private suspend fun raiseItemToTopIfFound(
//        historyList: MutableList<HistoryMealEntity>, historyMealEntity: HistoryMealEntity
//    ) {
//        historyList.remove(historyMealEntity)
//        addToHistory(historyList, historyMealEntity)
//    }
//
//    private suspend fun addToHistory(
//        historyList: MutableList<HistoryMealEntity>, historyMealEntity: HistoryMealEntity
//    ) {
//        historyList.add(historyMealEntity)
//        mealRepository.addToHistoryMeals(historyList)
//    }
//}

class AddToHistoryMealsUseCase @Inject constructor(
    private val mealRepository: MealRepository,
    private val getHistoryMealsUsecase: GetHistoryMealsUsecase,
) {
    suspend operator fun invoke(historyMealEntity: HistoryMealEntity) {
        try {
            val historyList = getHistoryMealsUsecase().first().toMutableList()

            if (historyList.contains(historyMealEntity)) {
                raiseItemToTopIfFound(historyList, historyMealEntity)
            } else {
                historyList.add(historyMealEntity)
                mealRepository.addToHistoryMeals(historyList)
            }
        } catch (e: Exception) {
            // Handle exception
            Log.e("TAG", "Error: $e")
        }
    }


    private suspend fun raiseItemToTopIfFound(
        historyList: MutableList<HistoryMealEntity>, historyMealEntity: HistoryMealEntity
    ) {
        historyList.remove(historyMealEntity)
        addToHistory(historyList, historyMealEntity)
    }

    private suspend fun addToHistory(
        historyList: MutableList<HistoryMealEntity>, historyMealEntity: HistoryMealEntity
    ) {
        historyList.add(0, historyMealEntity)
        mealRepository.addToHistoryMeals(historyList)
    }
}
