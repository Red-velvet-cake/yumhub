package com.red_velvet.yumhub.ui.base

import androidx.recyclerview.widget.DiffUtil

class BaseDiffUtil<T>(
    private val oldItems: List<T>,
    private val newItems: List<T>,
    private val checkIfSameItem: (oldItem: T, newItem: T) -> Boolean,
    private val checkIfSameContent: (oldItem: T, newItem: T) -> Boolean
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return checkIfSameItem(oldItems[oldItemPosition], newItems[newItemPosition])
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return checkIfSameContent(oldItems[oldItemPosition], newItems[newItemPosition])
    }
}


