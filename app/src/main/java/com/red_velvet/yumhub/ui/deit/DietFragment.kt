package com.red_velvet.yumhub.ui.deit

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentDeitBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DietFragment  : BaseFragment<FragmentDeitBinding, DietUIState, DietViewModel>(){
    @LayoutRes
    override val layoutIdFragment: Int= R.layout.fragment_deit
    override val viewModel: DietViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val dietAdapter = DietAdapter(mutableListOf())
        binding.recipeDietRecyclerView.adapter = dietAdapter
        super.onViewCreated(view, savedInstanceState)
    }
}