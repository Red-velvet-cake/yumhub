package com.red_velvet.yumhub.ui.home

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentHomeBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val comicsAdapter = RecipeCategoriesAdapter(emptyList(), viewModel)
        val popularRecipeAdapter = PopularRecipeAdapter(emptyList(), viewModel)
        val quickRecipeAdapter = QuickRecipeAdapter(emptyList(), viewModel)

        binding.apply {
            categoryRecyclerView.adapter = comicsAdapter
            popularRecyclerView.adapter = popularRecipeAdapter
            healthyRecyclerView.adapter = popularRecipeAdapter
            quickRecyclerView.adapter = quickRecipeAdapter
        }
    }
}