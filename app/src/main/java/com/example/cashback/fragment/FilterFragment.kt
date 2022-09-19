package com.example.e24_mobile_new.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.cashback.databinding.FragmentFilterBinding
import com.google.android.material.slider.RangeSlider

class FilterFragment : Fragment() {
    private val binding by lazy {
        FragmentFilterBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        setListeners()
        setSpinner()
        return binding.root
    }

    private fun setSpinner() {
        binding.filterMaterialAutoComplete.setAdapter(ArrayAdapter(requireContext(),android.R.layout.simple_dropdown_item_1line,cities))
    }

    private fun setListeners() {
        binding.cashbackRangesSlider.addOnChangeListener(RangeSlider.OnChangeListener { slider, value, fromUser ->
            binding.cashbackWithPercentage.text = "${slider.values[0].toInt()} - ${slider.values[1].toInt()}%"
        })
    }


    private val cities = arrayListOf<String>(
        "Baku", "Sumgait", "Xirdalan", "Mingachevir", "Ganja", "Lankaran"
    )

    //TODO Ui section done except transaction between Fragments
}