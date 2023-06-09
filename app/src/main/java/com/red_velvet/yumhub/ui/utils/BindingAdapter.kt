package com.red_velvet.yumhub.ui.utils

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.StateListDrawable
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.ui.base.BaseAdapter




@BindingAdapter("app:showIfListEmpty")
fun showIfListEmpty(view: View, value: Boolean) {
    view.isVisible = value
}
@BindingAdapter("app:showIfAsc")
fun showIfAsc(view: View, value: String) {
    view.isVisible = value == "asc"
}
@BindingAdapter("app:showIfDsc")
fun showIfDsc(view: View, value: String) {
    view.isVisible = value == "dsc"
}
@BindingAdapter("app:hideIfSortDirction")
fun hideIfSortDirction(view: View, value: String) {
    view.isVisible = !(value == "asc" ||value == "dsc")
}
@BindingAdapter("app:hideIfListEmpty")
fun hideIfListEmpty(view: View, value: Boolean) {
    view.isVisible = !value
}

@BindingAdapter("app:showIfLoading")
fun showIfLoading(view: View, value: Boolean) {
    view.isVisible = value
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


@BindingAdapter(value = ["chipBackgroundTint",])
fun setChipBackgroundTint(chip: Chip, colorLiveData: MutableLiveData<Int>) {

        colorLiveData.value?.let { color ->
            chip.chipBackgroundColor = ColorStateList.valueOf(color)
        }

}

@BindingAdapter(value = ["app:hideIfSearchInputEmpty"])
fun <T> hideIfSearchInputEmpty(view: View, text: String,) {
     if (text.isEmpty()) {

         view.visibility =  View.INVISIBLE
    }
}
@BindingAdapter(value = ["app:searchText","app:isResultEmpty","app:loading"])
fun <T> hideIfInputEmptyOrNoResult(view: View, searchText: String,isResultEmpty:Boolean,loading:Boolean) {
    if (searchText.isNotEmpty()) {
        view.visibility =  View.INVISIBLE
    }else if(searchText.isEmpty() && isResultEmpty ){
        view.visibility =  View.INVISIBLE
    }else  if(loading){
        view.visibility =  View.INVISIBLE
    }else {
        view.visibility =  View.VISIBLE
    }
}
@BindingAdapter(value = ["app:sortDir","app:isResultEmpty","app:InputText"])
fun <T> hideIfNoResultOrSort(view: View, sortDir: String,isResultEmpty:Boolean,InputText:String) {
    if (sortDir.isNotEmpty()) {
        view.visibility =  View.GONE
    }else  if(isResultEmpty && InputText.isNotEmpty() ){
        view.visibility =  View.GONE
    }else {
        view.visibility =  View.VISIBLE
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