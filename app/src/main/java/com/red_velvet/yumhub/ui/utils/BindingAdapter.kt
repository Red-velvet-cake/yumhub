package com.red_velvet.yumhub.ui.utils

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter("app:showWhenListNotEmpty")
fun <T> showWhenListNotEmpty(view: View, list: List<T>) {
    view.isVisible = list.isNotEmpty() == true
}

@BindingAdapter("app:showWhenListEmpty")
fun <T> showWhenListEmpty(view: View, list: List<T>) {
    view.isVisible = list.isEmpty() == true
}
@BindingAdapter("app:hideWhenListIsEmpty")
fun <T> hideWhenListIsEmpty(view: View, list: List<T>?) {
    if (list?.isEmpty() == true) {
        view.visibility = View.INVISIBLE
    }
}

@BindingAdapter(value = ["app:error", "app:loading"])
fun <T> showWhenSuccess(view: View, error: List<T>?, loading: Boolean) {
    view.isVisible = error?.isEmpty() == true && !loading
}

@BindingAdapter(value = ["app:noError", "app:doneLoad", "app:emptyData"])
fun <T, M> showWhenNoData(view: View, error: List<T>?, loading: Boolean, data: List<M>?) {
    view.isVisible = error.isNullOrEmpty() && !loading && data.isNullOrEmpty()
}