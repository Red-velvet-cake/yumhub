package com.red_velvet.yumhub.ui.util

import android.os.Build
import android.text.Html
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.red_velvet.yumhub.ui.base.ErrorUIState

@BindingAdapter("android:showNoInternet")
fun showNoInternet(view: View, errorState: ErrorUIState?) {
    view.visibility = if (errorState is ErrorUIState.NoInternet) View.VISIBLE else View.GONE
}

@BindingAdapter("android:showUnauthorized")
fun showUnauthorized(view: View, errorState: ErrorUIState?) {
    view.visibility = if (errorState is ErrorUIState.UnAuthorized) View.VISIBLE else View.GONE
}

@BindingAdapter("android:showTimeout")
fun showTimeout(view: View, errorState: ErrorUIState?) {
    view.visibility = if (errorState is ErrorUIState.ConnectionTimeout) View.VISIBLE else View.GONE
}

@BindingAdapter("android:showInternalServerError")
fun showInternalServerError(view: View, errorState: ErrorUIState?) {
    view.visibility =
        if (errorState is ErrorUIState.InternalServerError) View.VISIBLE else View.GONE
}

@BindingAdapter("android:showHtml")
fun showHtml(view: TextView, html: String?) {
    view.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(html, Html.FROM_HTML_MODE_COMPACT)
    } else {
        Html.fromHtml(html)
    }
}

