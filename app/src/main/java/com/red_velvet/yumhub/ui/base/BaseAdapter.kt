package com.red_velvet.yumhub.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.red_velvet.yumhub.BR


interface BaseInteractionListener
abstract class BaseAdapter<T>(
    private var items: List<T>,
    private var listener: BaseInteractionListener = object : BaseInteractionListener {},
) : RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {

    abstract val layoutId: Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutId,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentItem = items[position]
        when (holder) {
            is ItemViewHolder -> {
                holder.binding.setVariable(BR.item, currentItem)
                holder.binding.setVariable(BR.listener, listener)
            }
        }
    }

    open fun setItems(newItems: List<T>) {
        val diffResult = DiffUtil.calculateDiff(
            BaseDiffUtil(
                items,
                newItems,
                ::areItemsTheSame,
                ::areContentsTheSame,
            )
        )
        items = newItems
        diffResult.dispatchUpdatesTo(this)
        notifyDataSetChanged()
    }

    open fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    open fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    fun getItems() = items

    override fun getItemCount() = items.size

    class ItemViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)

    abstract class BaseViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

}