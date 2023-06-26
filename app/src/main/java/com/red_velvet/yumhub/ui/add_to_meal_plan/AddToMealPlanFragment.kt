package com.red_velvet.yumhub.ui.add_to_meal_plan

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.chip.ChipGroup.OnCheckedStateChangeListener
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentAddToMealPlanBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.Calendar

@AndroidEntryPoint
class AddToMealPlanFragment :
    BaseFragment<FragmentAddToMealPlanBinding, AddToMealPlanUiState, AddToMealPlanUiEffect, AddToMealPlanViewModel>(),
    OnCheckedStateChangeListener {

    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_add_to_meal_plan

    override val viewModel: AddToMealPlanViewModel by viewModels()
    override fun observeOnUIEffects() {
        lifecycleScope.launch { viewModel.effect.collectLatest { handleUIEffect(it) } }
    }

    override fun handleUIEffect(uiEffect: AddToMealPlanUiEffect) {
        when (uiEffect) {
            AddToMealPlanUiEffect.InvalidInput -> onInvalidInput()
            AddToMealPlanUiEffect.ClickOnCancelAddToMealPlan -> onCancelAddToMealPlan()
            AddToMealPlanUiEffect.AddToMealPlan -> onAddToMealPlan()
        }
    }

    private fun onAddToMealPlan() {
        Toast.makeText(requireContext(), "Added to meal plan", Toast.LENGTH_SHORT).show()
        findNavController().navigateUp()
    }

    private fun onCancelAddToMealPlan() {
        findNavController().navigateUp()
    }

    private fun onInvalidInput() {
        Toast.makeText(requireContext(), "Invalid input date", Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mealPlanChipGroup.setOnCheckedStateChangeListener(this)
        val calender = Calendar.getInstance()
        binding.datePicker.minDate = calender.timeInMillis
    }

    override fun onCheckedChanged(group: ChipGroup, checkedIds: MutableList<Int>) {
        val selectedChipId = checkedIds.firstOrNull() ?: return
        val selectedChip = group.findViewById<Chip>(selectedChipId)
        when (selectedChip.id) {
            R.id.breakfast_chip -> viewModel.onChooseMealPlanTime(BREAKFAST_TIME)
            R.id.lunch_chip -> viewModel.onChooseMealPlanTime(LUNCH_TIME)
            R.id.dinner_chip -> viewModel.onChooseMealPlanTime(DINNER_TIME)
        }
    }

    private companion object {
        const val BREAKFAST_TIME = 0
        const val LUNCH_TIME = 1
        const val DINNER_TIME = 2
    }

}

