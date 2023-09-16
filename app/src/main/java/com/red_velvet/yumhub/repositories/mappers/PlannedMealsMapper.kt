package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.DayPlannedMealsEntity
import com.red_velvet.yumhub.domain.models.PlannedMealEntity
import com.red_velvet.yumhub.domain.utils.orZero
import com.red_velvet.yumhub.remote.resources.meal_plan.DayResource
import com.red_velvet.yumhub.remote.resources.meal_plan.ItemResource
import com.red_velvet.yumhub.remote.resources.meal_plan.WeekMealPlanResource
import java.text.SimpleDateFormat
import java.util.Date


fun ItemResource.toPlannedMealEntity(): PlannedMealEntity {
    return PlannedMealEntity(
        id = valueResource?.id.orZero(),
        slot = slot.orZero(),
        title = valueResource?.title.orEmpty(),
        description = type.orEmpty(),
        imageUrl = "valueResource?.imageUrl.orEmpty()"
    )
}

fun List<ItemResource>.toPlannedMealEntity(): List<PlannedMealEntity> {
    return map { it.toPlannedMealEntity() }
}

fun DayResource.toDayPlannedMealEntity(): DayPlannedMealsEntity {
    return DayPlannedMealsEntity(
        timestamp = date.orZero(),
        dayOfWeek = day.orEmpty().toShortDay(),
        datOfMonth = date.orZero().toDayOfMonth(),
        meals = itemResources?.toPlannedMealEntity().orEmpty()
    )
}

fun List<DayResource>.toDayPlannedMealEntity(): List<DayPlannedMealsEntity> {
    return map { it.toDayPlannedMealEntity() }
}

fun WeekMealPlanResource.toDayPlannedMealEntity(): List<DayPlannedMealsEntity> {
    return dayResources?.toDayPlannedMealEntity().orEmpty()
}

private fun String.toShortDay(): String {
    return when (this) {
        "Monday" -> "Mon"
        "Tuesday" -> "Tue"
        "Wednesday" -> "Wed"
        "Thursday" -> "Thu"
        "Friday" -> "Fri"
        "Saturday" -> "Sat"
        "Sunday" -> "Sun"
        else -> ""
    }
}

private fun Int.toDayOfMonth(): String {
    val date = Date(this.toLong() * 1000)
    val formatter = SimpleDateFormat("dd")
    return formatter.format(date)
}
