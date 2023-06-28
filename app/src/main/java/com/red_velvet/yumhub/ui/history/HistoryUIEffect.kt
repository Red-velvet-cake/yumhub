package com.red_velvet.yumhub.ui.history

import com.red_velvet.yumhub.ui.base.BaseUIEffect

sealed interface HistoryUIEffect : BaseUIEffect {

    data class ClickOnItem(val itemId: Int) : HistoryUIEffect

}