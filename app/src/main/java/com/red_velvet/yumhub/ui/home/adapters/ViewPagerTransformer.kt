package com.red_velvet.yumhub.ui.home.adapters

import android.view.View
import androidx.viewpager.widget.ViewPager

class ViewPagerTransformer : ViewPager.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        val MIN_SCALE = 0.75f
        val MIN_ALPHA = 0.5f

        if (position < -1) {
            page.alpha = 0f
        } else if (position <= 1) {
            val scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position))
            val alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))

            page.scaleX = scaleFactor
            page.scaleY = scaleFactor
            page.alpha = alpha
        } else {
            page.alpha = 0f
        }
    }
}
