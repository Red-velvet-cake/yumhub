package com.red_velvet.yumhub.ui.mealPlan

import com.red_velvet.yumhub.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MealPlanViewModel @Inject constructor() :
    BaseViewModel<MealPlanUiState, MealPlanUiEffect>(MealPlanUiState()),
    MealPlanInteractionListener {



    init {
        initCalendarDays()
        initBreakfastMeals()
        initLunchMeals()
        initDinnerMeals()
    }

    private fun initCalendarDays() {
        val fakeCalendarDays = listOf(
            MealPlanUiState.DayUiState("Mon", "12"),
            MealPlanUiState.DayUiState("Tue", "13", isSelected = true),
            MealPlanUiState.DayUiState("Wed", "14"),
            MealPlanUiState.DayUiState("Thu", "15"),
            MealPlanUiState.DayUiState("Fri", "16"),
            MealPlanUiState.DayUiState("Sat", "17"),
            MealPlanUiState.DayUiState("Sun", "18"),
        )
        _state.update { it.copy(calendarDays = fakeCalendarDays) }
    }

    private fun initBreakfastMeals() {
        val fakeBreakfastMeals = listOf(
            MealPlanUiState.MealUiState(
                1,
                "Breakfast 1",
                "Description 1",
                "https://picsum.photos/200/300"
            ),
            MealPlanUiState.MealUiState(
                2,
                "Breakfast 2",
                "Description 2",
                "https://picsum.photos/200/300"
            ),
            MealPlanUiState.MealUiState(
                3,
                "Breakfast 3",
                "Description 3",
                "https://picsum.photos/200/300"
            ),
            MealPlanUiState.MealUiState(
                4,
                "Breakfast 4",
                "Description 4",
                "https://picsum.photos/200/300"
            ),
        )
        _state.update { it.copy(breakfastMeals = fakeBreakfastMeals) }
    }

    private fun initLunchMeals() {
        val fakeLunchMeals = listOf(
            MealPlanUiState.MealUiState(
                1,
                "Lunch 1",
                "Description 1",
                "https://picsum.photos/200/300"
            ),
            MealPlanUiState.MealUiState(
                2,
                "Lunch 2",
                "Description 2",
                "https://picsum.photos/200/300"
            ),
            MealPlanUiState.MealUiState(
                3,
                "Lunch 3",
                "Description 3",
                "https://picsum.photos/200/300"
            ),
            MealPlanUiState.MealUiState(
                4,
                "Lunch 4",
                "Description 4",
                "https://picsum.photos/200/300"
            ),
        )
        _state.update { it.copy(lunchMeals = fakeLunchMeals) }
    }

    private fun initDinnerMeals() {
        val fakeDinnerMeals = listOf(
            MealPlanUiState.MealUiState(
                1,
                "Dinner 1",
                "Description 1",
                "https://picsum.photos/200/300"
            ),
            MealPlanUiState.MealUiState(
                2,
                "Dinner 2",
                "Description 2",
                "https://picsum.photos/200/300"
            ),
            MealPlanUiState.MealUiState(
                3,
                "Dinner 3",
                "Description 3",
                "https://picsum.photos/200/300"
            ),
            MealPlanUiState.MealUiState(
                4,
                "Dinner 4",
                "Description 4",
                "https://picsum.photos/200/300"
            ),
        )
        _state.update { it.copy(dinnerMeals = fakeDinnerMeals) }
    }

}