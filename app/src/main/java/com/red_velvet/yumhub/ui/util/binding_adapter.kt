package com.red_velvet.yumhub.ui.util

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.ui.base.BaseAdapter
import com.red_velvet.yumhub.ui.base.ErrorUIState
import com.red_velvet.yumhub.ui.home.HomeSliderItemUiState
import com.red_velvet.yumhub.ui.home.adapters.HomeSliderAdapter

@BindingAdapter("android:hideWhenErr")
fun hideWhenError(view: View, errorState: ErrorUIState?) {
    view.isVisible = errorState == null
}

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
@BindingAdapter(value=["app:showIfListEmpty","loading","app:error"])
fun showIfNotFound(view: View, value: Boolean,loading:Boolean,errorState: ErrorUIState?) {
    if(errorState != null){
        view.isVisible = false
    }else if (loading) {
        view.isVisible = false;
    }else{
        view.isVisible = value
    }
}
@BindingAdapter("app:showIfTrue")
fun showIfTrue(view: View, value: Boolean) {
    if (value) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}
@BindingAdapter("app:changeStyleIfTrue")
fun changeStyleIfTrue(view: View, value: Boolean) {
    if (value) {
        view.setBackgroundResource(R.drawable.rounded_border_full_indectior)
        val layoutParams = view.layoutParams
        layoutParams.width = view.context.resources.getDimensionPixelSize(R.dimen.space_40dp)
        view.layoutParams = layoutParams
    } else {
        view.setBackgroundResource(R.drawable.rounded_border_indecator)
        val layoutParams = view.layoutParams
        layoutParams.width = view.context.resources.getDimensionPixelSize(R.dimen.size_6dp)
        view.layoutParams = layoutParams
    }
}
@BindingAdapter("app:showIfAsc")
fun showIfAsc(view: View, value: String) {
    if (value == "asc") {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}
@BindingAdapter("app:hideIfZero")
fun hideIfZero(view: View, value: Int) {
    if (value == 0) {
        view.isVisible = false
    }
}
@BindingAdapter("app:showIfDsc")
fun showIfDsc(view: View, value: String) {
    if (value == "dsc") {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }

}
@BindingAdapter("app:hideIfListEmpty")
fun hideIfListEmpty(view: View, value: Boolean) {
    view.isVisible = !value
}

@BindingAdapter("app:showIfLoading")
fun showIfLoading(view: View, value: Boolean) {
    view.isVisible = value
}

@BindingAdapter(value = ["app:searchInput", "app:loadingSearch", "app:isResultEmpty"])
fun <T> hideWhenSuccessSearch(view: View, text: String, loading: Boolean, isResultEmpty: Boolean) {
    view.visibility = if (text.isNotBlank() && !loading) {
        View.VISIBLE
    } else if (text.isEmpty() && !isResultEmpty) {
        View.VISIBLE
    } else {
        View.INVISIBLE
    }
}

@BindingAdapter(value = ["app:searchInput", "app:isResultEmpty"])
fun <T> showToClearIfNoResult(view: View, text: String, isResultEmpty: Boolean) {
    if (isResultEmpty) {
        view.visibility = View.VISIBLE
    } else if (text.isEmpty()) {
        view.visibility = View.GONE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["app:searchText", "app:isResultEmpty", "app:loading", "app:resultList"])
fun <T> hideIfInputEmptyOrNoResult(
    view: View,
    searchText: String,
    isResultEmpty: Boolean,
    loading: Boolean,
    resultList: List<T>
) {
    if (searchText.isNotEmpty()) {
        view.visibility = View.INVISIBLE
    } else if (searchText.isEmpty() && isResultEmpty) {
        view.visibility = View.INVISIBLE
    } else if (loading) {
        view.visibility = View.INVISIBLE
    } else if (searchText.isEmpty() && resultList.isNotEmpty()) {
        view.visibility = View.INVISIBLE
    } else {
        view.visibility = View.VISIBLE
    }
}

@BindingAdapter(value = ["app:sortDir", "app:isResultEmpty", "app:InputText"])
fun <T> hideIfNoResultOrSort(
    view: View,
    sortDir: String,
    isResultEmpty: Boolean,
    InputText: String
) {
    if (sortDir.isNotEmpty()) {
        view.visibility = View.GONE
    } else if (isResultEmpty && InputText.isNotEmpty()) {
        view.visibility = View.GONE
    } else {
        view.visibility = View.VISIBLE
    }
}

@BindingAdapter(value = ["app:list","app:loading","app:error"])
fun<T> hideIfLoadingShowIfListEmpty(view: View, list: List<T>,loading:Boolean,error: ErrorUIState?){
    if(loading){
        view.visibility =  View.GONE
    }else if(error != null){
        view.visibility =  View.GONE
    }else if(list.isEmpty()){
        view.visibility =  View.VISIBLE
    }else{
        view.visibility =  View.GONE
    }
}

@BindingAdapter(value = ["app:listResult", "app:loading"])
fun <T> hideIfLoadingShowIfListNotEmpty(view: View, listResult: List<T>, loading: Boolean) {
    if (loading) {
        view.visibility = View.GONE
    } else if (listResult.isNotEmpty()) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}


@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>) {
    (view.adapter as BaseAdapter<T>?)?.setItems(items)

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
        .placeholder(R.drawable.baseline_image_24)
        .into(view)
}

@BindingAdapter("app:htmlText")
fun showHtml(view: TextView, html: String?) {
    if (html != null) {
        view.text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}

@BindingAdapter("android:showWhenEmpty")
fun showWhenEmpty(view: View, boolean: Boolean) {
    view.isVisible = boolean
}

@BindingAdapter("pagerItems")
fun setViewPagerItems(viewPager: ViewPager, items: List<HomeSliderItemUiState>?) {
    if (items == null) {
        return
    }
    val adapter = HomeSliderAdapter(items)
    viewPager.adapter = adapter
}