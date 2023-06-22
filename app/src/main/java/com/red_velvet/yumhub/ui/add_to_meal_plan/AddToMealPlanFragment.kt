package com.red_velvet.yumhub.ui.add_to_meal_plan

import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.FragmentAddToMealPlanBinding
import com.red_velvet.yumhub.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddToMealPlanFragment :
    BaseFragment<FragmentAddToMealPlanBinding, AddToMealPlanUiState, AddToMealPlanViewModel>(),
    RadioGroup.OnCheckedChangeListener {

    @LayoutRes
    override val layoutIdFragment: Int = R.layout.fragment_add_to_meal_plan

    override val viewModel: AddToMealPlanViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mealsRadioGroup.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(radioGroup: RadioGroup?, checkedId: Int) {
        when (checkedId) {
            R.id.breakfast_radio_button -> viewModel.onChooseMealPlanTime(0)
            R.id.lunch_radio_button -> viewModel.onChooseMealPlanTime(1)
            R.id.dinner_radio_button -> viewModel.onChooseMealPlanTime(2)
        }
    }


}