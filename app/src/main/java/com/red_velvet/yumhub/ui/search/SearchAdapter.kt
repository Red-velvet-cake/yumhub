package com.red_velvet.yumhub.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.red_velvet.yumhub.databinding.ItemSearchCardBinding
import javax.inject.Inject

class SearchAdapter @Inject constructor() :
    PagingDataAdapter<SearchResultUIState, SearchViewHolder>(Comparator) {
    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        getItem(position)?.let { searchResultUIState -> holder.bind(searchResultUIState) }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = ItemSearchCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }
    object Comparator : DiffUtil.ItemCallback<SearchResultUIState>() {
        override fun areItemsTheSame(oldItem: SearchResultUIState, newItem: SearchResultUIState): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: SearchResultUIState, newItem: SearchResultUIState): Boolean {
            return oldItem == newItem
        }
    }
}

class SearchViewHolder(private val binding: ItemSearchCardBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(searchResultUIState: SearchResultUIState) {
        binding.executeWithAction {
            this.item = searchResultUIState
//            this.listener =
        }
    }
}
fun <T : ViewDataBinding> T.executeWithAction(action: T.() -> Unit) {
    action()
    executePendingBindings()
}