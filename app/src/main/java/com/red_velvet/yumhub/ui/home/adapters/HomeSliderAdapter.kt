package com.red_velvet.yumhub.ui.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.red_velvet.yumhub.databinding.ItemHomeSliderBinding
import com.red_velvet.yumhub.ui.home.HomeSliderItemUiState

class HomeSliderAdapter(private var homeSliderList: List<HomeSliderItemUiState>) :
    PagerAdapter() {
    override fun getCount(): Int {
        return homeSliderList.size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = LayoutInflater.from(container.context)
        val binding = ItemHomeSliderBinding.inflate(layoutInflater, container, false)
        val item = homeSliderList[position]
        binding.featuredHomeImageView.setImageResource(item.imageResource)
        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }

    fun update(newHomeSliderList: List<HomeSliderItemUiState>) {
        homeSliderList = newHomeSliderList
        notifyDataSetChanged()
    }
}
