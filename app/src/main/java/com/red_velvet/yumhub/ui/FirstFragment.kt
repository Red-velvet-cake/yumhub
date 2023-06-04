package com.red_velvet.yumhub.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.red_velvet.yumhub.databinding.FragmentFirstBinding
import com.red_velvet.yumhub.ui.search.SearchFragment

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.i("GGGOOOOOO","hi")

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
        binding.buttonFirst.setOnClickListener {
            Log.i("GGGOOOOOO","hi")
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}