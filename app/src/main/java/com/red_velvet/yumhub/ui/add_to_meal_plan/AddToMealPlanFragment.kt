package com.red_velvet.yumhub.ui.add_to_meal_plan

import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
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
    RadioGroup.OnCheckedChangeListener {

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
        Toast.makeText(requireContext(), "Added to meal plan failed", Toast.LENGTH_SHORT).show()
    }

    private fun onInvalidInput() {
        Toast.makeText(requireContext(), "Invalid input date", Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mealsRadioGroup.setOnCheckedChangeListener(this)
        val c = Calendar.getInstance()
        binding.datePicker.minDate = c.timeInMillis
    }

    override fun onCheckedChanged(radioGroup: RadioGroup?, checkedId: Int) {
        when (checkedId) {
            R.id.breakfast_radio_button -> viewModel.onChooseMealPlanTime(0)
            R.id.lunch_radio_button -> viewModel.onChooseMealPlanTime(1)
            R.id.dinner_radio_button -> viewModel.onChooseMealPlanTime(2)
        }
    }

}