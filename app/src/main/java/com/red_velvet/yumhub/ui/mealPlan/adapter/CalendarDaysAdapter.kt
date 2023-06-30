package com.red_velvet.yumhub.ui.mealPlan.adapter

import com.red_velvet.yumhub.BR
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.ItemCalendarDayBinding
import com.red_velvet.yumhub.ui.base.BaseAdapter
import com.red_velvet.yumhub.ui.mealPlan.MealPlanInteractionListener
import com.red_velvet.yumhub.ui.mealPlan.MealPlanUiState

class CalendarDaysAdapter(
    items: List<MealPlanUiState.DayPlannedMealsUiState>,
    private val listener: MealPlanInteractionListener
) : BaseAdapter<MealPlanUiState.DayPlannedMealsUiState>(items, listener) {
    override val layoutId: Int = R.layout.item_calendar_day

    private var selectedPosition = 1
    private var lastSelectedPosition = 1

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentItem = getItems()[position]
        when (holder) {
            is ItemViewHolder -> {
                holder.binding.setVariable(BR.item, currentItem)
                holder.binding.setVariable(BR.listener, listener)
                if (position == selectedPosition) {
                    setSelectedBackground(holder)
                } else {
                    setUnselectedBackground(holder)
                }
                setOnClickListener(holder, currentItem)
            }
        }
    }

    private fun setSelectedBackground(holder: ItemViewHolder) {
        val binding = holder.binding as ItemCalendarDayBinding
        binding.apply {
            root.setBackgroundResource(R.drawable.bg_selected_day)
            textDayOfWeek.setTextColor(root.context.getColor(R.color.fontColor_white))
            textDayOfMonth.setTextColor(root.context.getColor(R.color.fontColor_white))
        }
    }

    private fun setUnselectedBackground(holder: ItemViewHolder) {
        val binding = holder.binding as ItemCalendarDayBinding
        binding.apply {
            root.setBackgroundResource(R.drawable.bg_unselected_day)
            textDayOfWeek.setTextColor(root.context.getColor(R.color.fontColor_primary))
            textDayOfMonth.setTextColor(root.context.getColor(R.color.fontColor_primary))
        }
    }

    private fun setOnClickListener(
        holder: ItemViewHolder,
        currentItem: MealPlanUiState.DayPlannedMealsUiState
    ) {
        holder.binding.root.setOnClickListener {
            listener.onDaySelected(currentItem.date)
            lastSelectedPosition = selectedPosition
            selectedPosition = holder.adapterPosition
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)
        }
    }
}