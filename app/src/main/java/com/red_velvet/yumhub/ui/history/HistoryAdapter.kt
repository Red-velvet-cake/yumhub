package com.red_velvet.yumhub.ui.history

import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.ui.base.BaseAdapter
import com.red_velvet.yumhub.ui.base.BaseInteractionListener

class HistoryAdapter(
    item: List<HistoryUIState.HistoryItemUIState>,
    private val listener: HistoryInteractionListener
) :
    BaseAdapter<HistoryUIState.HistoryItemUIState>(item, listener) {
    override val layoutId: Int = R.layout.item_history_card

    fun removeItem(position: Int) {
        if (position in getItems().indices) {
            val a = getItems()[position]
            listener.onHistoryRecipeRemoved(getItems()[position].toEntity())
        }
    }
}

interface HistoryInteractionListener : BaseInteractionListener {

    fun onHistoryItemClicked(itemId: Int)

    fun onHistoryRecipeRemoved(recipe: RecipeEntity)


}