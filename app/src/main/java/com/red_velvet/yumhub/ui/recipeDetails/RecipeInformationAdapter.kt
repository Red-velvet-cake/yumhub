package com.red_velvet.yumhub.ui.recipeDetails

import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.ui.base.BaseAdapter
import com.red_velvet.yumhub.ui.base.BaseInteractionListener


class DishTypesAdapter(
    val list: List<DishTypeUIState>,
    val listener: DishTypeListener
) : BaseAdapter<DishTypeUIState>(list, listener) {
    override val layoutId: Int = R.layout.item_dish_type
}

interface DishTypeListener : BaseInteractionListener {
    fun onDishTypeClicked(dish: String)
}

class IngredientsAdapter(
    val list: List<IngredientsUIState>,
    val listener: IngredientsListener
) : BaseAdapter<IngredientsUIState>(list, listener) {
    override val layoutId: Int = R.layout.item_ingredient
}

interface IngredientsListener : BaseInteractionListener {
    fun onIngredientClicked(id: Int)
}