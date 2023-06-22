package com.red_velvet.yumhub.domain.usecases

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.ZoneId
import javax.inject.Inject

class ConvertDateToTimestampUseCase @Inject constructor() {

    @RequiresApi(Build.VERSION_CODES.O)
    operator fun invoke(year: Int, month: Int, dayOfMonth: Int): Long {
        return LocalDateTime.of(year, month, dayOfMonth, 0, 0, 0)
            .atZone(ZoneId.systemDefault())
            .toInstant()
            .toEpochMilli()
    }
}