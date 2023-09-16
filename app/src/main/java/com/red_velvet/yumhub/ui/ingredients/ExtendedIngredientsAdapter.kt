package com.red_velvet.yumhub.ui.ingredients

import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.ui.base.BaseAdapter
import com.red_velvet.yumhub.ui.base.BaseInteractionListener


class ExtendedIngredientsAdapter(
    val list: List<ExtendedIngredientUIState>,
    val listener: ExtendedIngredientsListener
) : BaseAdapter<ExtendedIngredientUIState>(list, listener) {
    override val layoutId: Int = R.layout.item_extended_ingredients
}

interface ExtendedIngredientsListener : BaseInteractionListener {
    fun ingredientClicked(id: Int)
}