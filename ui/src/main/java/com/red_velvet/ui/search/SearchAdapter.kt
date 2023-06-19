package com.red_velvet.ui.search

import com.red_velvet.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.mylibrary.R
import com.red_velvet.ui.base.BaseAdapter

class SearchAdapter (item: List<SearchRecipeEntity>,) :
    BaseAdapter<SearchRecipeEntity>(item) {
    override val layoutId: Int = R.layout.item_search_card

}