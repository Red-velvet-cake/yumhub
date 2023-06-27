package com.red_velvet.yumhub.ui.history

import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.domain.models.HistoryMealEntity
import com.red_velvet.yumhub.ui.base.BaseAdapter
import com.red_velvet.yumhub.ui.base.BaseInteractionListener

class HistoryAdapter(item: List<HistoryMealEntity>, listener: HistoryInteractionListener) :
    BaseAdapter<HistoryMealEntity>(item, listener) {
    override val layoutId: Int = R.layout.item_history_card
}

interface HistoryInteractionListener : BaseInteractionListener {

    fun onHistoryItemClicked(itemId: Int)

}