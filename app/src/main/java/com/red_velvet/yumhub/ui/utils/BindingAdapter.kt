package com.red_velvet.yumhub.ui.utils

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.ui.base.BaseAdapter


@BindingAdapter("app:hideWhenListIsNotEmpty")
fun <T> hideWhenListIsNotEmpty(view: View, list: List<T>?) {
    if (list?.isNotEmpty() == true) {
        view.visibility = View.INVISIBLE
    }
}

@BindingAdapter("app:showIfListEmpty")
fun showIfListEmpty(view: View, value: Boolean) {
    view.isVisible = value

}
@BindingAdapter("app:hideIfListEmpty")
fun hideIfListEmpty(view: View, value: Boolean) {
    view.isVisible = !value
}
@BindingAdapter("app:showIfLoading")
fun showIfLoading(view: View, value: Boolean) {
    view.isVisible = value
}
@BindingAdapter("app:hidIfLoading")
fun hidIfLoading(view: View, value: Boolean) {
    view.isVisible = !value
}
@BindingAdapter(value = ["app:searchInput", "app:errorSearch", "app:loadingSearch"])
fun <T> hideWhenSuccessSearch(view: View, text: String, error: List<T>?, loading: Boolean) {
    view.visibility = if (text.isNotBlank() && error.isNullOrEmpty() && !loading) {
        View.VISIBLE
    } else {
        View.INVISIBLE
    }
}
@BindingAdapter(value = ["app:hideISearchInputEmpty"])
fun <T> hideISearchInputEmpty(view: View, text: String,) {
    view.visibility = if (text.isEmpty()) {
        View.VISIBLE
    } else {
        View.INVISIBLE
    }
}

@BindingAdapter(value = ["app:setItems"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    if (items != null) {
        (view.adapter as BaseAdapter<T>).setItems(items)
    } else {
        (view.adapter as BaseAdapter<T>).setItems(emptyList())
    }
}
@BindingAdapter(value = ["app:imageUrl"])
fun loadImage(view: ImageView, image: String?) {
    Glide.with(view).load(image).placeholder(R.drawable.baseline_image_24).into(view)
}