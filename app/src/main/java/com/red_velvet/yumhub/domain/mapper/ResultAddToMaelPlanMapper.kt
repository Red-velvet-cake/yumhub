package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.remote.dtos.meal_plan.ResultAddToMealPlanDto
import com.red_velvet.yumhub.domain.models.ResultAddToMealPlan

fun ResultAddToMealPlanDto.toResultAddToMealPlanMapper(): ResultAddToMealPlan {
    return ResultAddToMealPlan(
        id = this.id,
        status = this.status
    )
}