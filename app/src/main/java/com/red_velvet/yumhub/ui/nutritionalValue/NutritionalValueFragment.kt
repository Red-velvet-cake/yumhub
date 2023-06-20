package com.red_velvet.yumhub.ui.nutritionalValue

import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentNutritionalValueBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NutritionalValueFragment : BaseFragment<FragmentNutritionalValueBinding,NutritionalValueUIState,NutritionalValueViewModel>() {
    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_nutritional_value
    override val viewModel: NutritionalValueViewModel by  viewModels()
}