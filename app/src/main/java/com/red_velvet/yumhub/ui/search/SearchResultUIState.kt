package com.red_velvet.yumhub.ui.search

import androidx.recyclerview.widget.DiffUtil

data class SearchResultUIState(
    val id: Int,
    val title: String,
    val image: String,
    val ingredientNumber: Int,
    val readyInMinutes: String,
)