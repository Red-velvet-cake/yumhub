package com.red_velvet.yumhub.ui.history

import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.red_velvet.yumhub.R

class HistoryItemTouchCallback(
    private val adapter: HistoryAdapter
) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean = false

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val position = viewHolder.adapterPosition
        adapter.removeItem(position)
//        adapter.showUndoSnackBar(viewHolder.itemView, adapter.getItems()[position])
    }

    override fun onChildDraw(
        canvas: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            val itemView = viewHolder.itemView
            val background = createBackground(recyclerView)
            val deleteIcon = getDeleteIcon(recyclerView)

            if (dX < 0) {
                // Swiping from right to left
                val cornerRadius = getCornerRadius(itemView)
                background.cornerRadius = cornerRadius
                background.setBounds(
                    itemView.left + dX.toInt(),
                    itemView.top,
                    itemView.right,
                    itemView.bottom
                )
            } else {
                // No swipe action or swiping from left to right (do not draw the background)
                background.setBounds(0, 0, 0, 0)
            }

            background.draw(canvas)

            drawDeleteIcon(canvas, deleteIcon, itemView, dX)
        }

        super.onChildDraw(canvas, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }

    private fun createBackground(recyclerView: RecyclerView): GradientDrawable {
        val backgroundColor = ResourcesCompat.getColor(
            recyclerView.resources,
            R.color.light_red,
            null
        )
        return GradientDrawable().apply {
            setColor(backgroundColor)
        }
    }

    private fun getDeleteIcon(recyclerView: RecyclerView): Drawable {
        return ResourcesCompat.getDrawable(recyclerView.resources, R.drawable.ic_basket, null)!!
    }

    private fun drawDeleteIcon(canvas: Canvas, deleteIcon: Drawable, itemView: View, dX: Float) {
        // Calculate the position of the delete icon
        val iconMargin = (itemView.height - deleteIcon.intrinsicHeight) / 2
        val iconTop = itemView.top + (itemView.height - deleteIcon.intrinsicHeight) / 2
        val iconLeft = itemView.right - iconMargin - deleteIcon.intrinsicWidth
        val iconRight = itemView.right - iconMargin
        val iconBottom = iconTop + deleteIcon.intrinsicHeight

        // Draw the delete icon
        deleteIcon.setBounds(iconLeft, iconTop, iconRight, iconBottom)
        deleteIcon.draw(canvas)
    }

    private fun getCornerRadius(view: View): Float {
        if (view is MaterialCardView) {
            return view.radius
        }
        return 0f
    }
}
