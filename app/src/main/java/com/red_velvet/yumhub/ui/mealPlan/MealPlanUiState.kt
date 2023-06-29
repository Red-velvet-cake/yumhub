package com.red_velvet.yumhub.ui.mealPlan

import com.red_velvet.yumhub.domain.models.DayPlannedMealsEntity
import com.red_velvet.yumhub.domain.models.PlannedMealEntity
import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState

data class MealPlanUiState(
    val daysPlannedMeals: List<DayPlannedMealsUiState> = emptyList(),
    val breakfastMeals: List<MealUiState> = emptyList(),
    val lunchMeals: List<MealUiState> = emptyList(),
    val dinnerMeals: List<MealUiState> = emptyList(),
    val selectedDay: Int? = null,
    val pagePosition: Int = 1,
    val isLoading: Boolean = false,
    val error: ErrorUIState? = null,
    val slot: Int = 1
) : BaseUiState {


    data class MealUiState(
        val id: Int,
        val name: String,
        val description: String,
        val slot: Int,
        val imageUrl: String,
    )

    data class DayPlannedMealsUiState(
        val date: Int,
        val dayOfWeek: String,
        val datOfMonth: String,
        val meals: List<MealUiState>
    )
}

fun PlannedMealEntity.toMealUiState(): MealPlanUiState.MealUiState {
    return MealPlanUiState.MealUiState(
        id = id,
        name = title,
        description = description,
        slot = slot,
        imageUrl = imageUrl
    )
}

fun List<PlannedMealEntity>.toMealUiState(): List<MealPlanUiState.MealUiState> {
    return map { it.toMealUiState() }
}

fun DayPlannedMealsEntity.toDayPlannedMealsUiState(): MealPlanUiState.DayPlannedMealsUiState {
    return MealPlanUiState.DayPlannedMealsUiState(
        date = timestamp,
        dayOfWeek = dayOfWeek,
        datOfMonth = datOfMonth,
        meals = meals.toMealUiState()
    )
}

fun List<DayPlannedMealsEntity>.toDayPlannedMealsUiState(): List<MealPlanUiState.DayPlannedMealsUiState> {
    if (this.isEmpty()) return emptyList()
    return map { it.toDayPlannedMealsUiState() }
}

fun List<DayPlannedMealsEntity>.toBreakfastMealsUiState(timestamp: Int?): List<MealPlanUiState.MealUiState> {
    if (this.isEmpty()) return emptyList()
    return filter { it.timestamp == timestamp }.flatMap { it.meals }
        .filter { it.slot == 1 }.toMealUiState()
}

fun List<DayPlannedMealsEntity>.toLunchMealsUiState(timestamp: Int?): List<MealPlanUiState.MealUiState> {
    if (this.isEmpty()) return emptyList()
    return filter { it.timestamp == timestamp }.flatMap { it.meals }
        .filter { it.slot == 2 }.toMealUiState()
}

fun List<DayPlannedMealsEntity>.toDinnerMealsUiState(timestamp: Int?): List<MealPlanUiState.MealUiState> {
    if (this.isEmpty()) return emptyList()
    return filter { it.timestamp == timestamp }.flatMap { it.meals }
        .filter { it.slot == 3 }.toMealUiState()
}