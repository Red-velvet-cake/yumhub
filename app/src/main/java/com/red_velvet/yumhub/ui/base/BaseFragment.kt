package com.red_velvet.yumhub.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.red_velvet.yumhub.BR

abstract class BaseFragment<
        VDB : ViewDataBinding,
        T : BaseUiState,
        EFFECT : BaseUIEffect,
        VM : BaseViewModel<T, EFFECT>,
        > : Fragment() {

    abstract val layoutIdFragment: Int
    abstract val viewModel: ViewModel

    private lateinit var _binding: VDB
    protected val binding: VDB
        get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeOnUIEffects()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, layoutIdFragment, container, false)
        _binding.apply {
            lifecycleOwner = viewLifecycleOwner
            setVariable(BR.viewModel, viewModel)
        }
        return _binding.root
    }

    abstract fun observeOnUIEffects()

    abstract fun handleUIEffect(uiEffect: EFFECT)
}