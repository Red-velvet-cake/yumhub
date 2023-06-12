package com.red_velvet.yumhub.ui.search

import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.yumhub.ui.base.BaseAdapter

class SearchAdapter (item: List<SearchRecipeEntity>,) :
    BaseAdapter<SearchRecipeEntity>(item) {
    override val layoutId: Int = R.layout.item_search_card

}