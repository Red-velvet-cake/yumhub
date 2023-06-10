package com.red_velvet.yumhub.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.red_velvet.yumhub.ui.base.BaseAdapter

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    (view.adapter as BaseAdapter<T>?)?.setItems(items ?: emptyList())
    view.scrollToPosition(0)
}

@BindingAdapter(value = ["app:setDrawableResource"])
fun setDrawableResourceToImageView(view: ImageView, image: String) {
    val resID = view.context.resources.getIdentifier(image, null, view.context.packageName)
    view.setImageResource(resID)
}

@BindingAdapter(value = ["app:imageUrl"])
fun loadImage(view: ImageView, imageUrl: String) {
    Glide.with(view).load(imageUrl)
        .fitCenter()
        .centerCrop()
        .into(view)
}
