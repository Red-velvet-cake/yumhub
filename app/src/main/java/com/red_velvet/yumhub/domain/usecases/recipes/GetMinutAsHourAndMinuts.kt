package com.red_velvet.yumhub.domain.usecases.recipes

import javax.inject.Inject

class GetMinutAsHourAndMinuts @Inject constructor() {

    operator fun invoke(readyInMinutes: String, ):String {
            return  formatMinutesAsDuration(readyInMinutes)
        }

  private  fun formatMinutesAsDuration(minutes: String): String {
        val hours = minutes.toInt()/ 60
        val remainingMinutes = minutes.toInt() % 60

        return if (hours > 0) {
            "$hours H $remainingMinutes Min"
        } else {
            "$remainingMinutes Min"
        }
    }
}