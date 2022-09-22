package com.example.cashback.fragment

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cashback.partners_adapter.PartnersFiltersAdapter
import com.example.cashback.fragment.subfragments.PartnersListSubFragment
import az.expressbank.e24.models.partnersmodel.FilterModel
import com.example.cashback.R
import com.example.cashback.databinding.FragmentPartnersBinding
import com.example.e24_mobile_new.fragment.FilterFragment
import com.example.cashback.fragment.subfragments.PartnersMapSubFragment
import com.example.cashback.retrofit.RetrofitBuilder
import kotlin.coroutines.suspendCoroutine


class PartnersFragment : Fragment() {
    private val binding by lazy {
        FragmentPartnersBinding.inflate(layoutInflater)
    }

    private val partnersListSubFragmentInstance by lazy {
        PartnersListSubFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        Log.d("MyTagHere", "onCreateView: ")
        setFilterAdapter()
        setListeners()
        setDefaultSubFragmentView()
        setFocusBackground(binding.btnPartnersList,binding.btnPartnersMap)
        connectRetrofit()
        return binding.root
    }

    private fun connectRetrofit() {
        GlobalScope.launch{
            val response = RetrofitBuilder.getInstance().getUsers()
        }

    }

    private fun setDefaultSubFragmentView() {
        childFragmentManager.beginTransaction()
            .replace(R.id.partners_container_view, partnersListSubFragmentInstance)
            .commit()
    }

    private fun setListeners() {
        binding.iconFilter.setOnClickListener(this::moveToFilterFragment)
        binding.btnPartnersMap.setOnClickListener(this::showMapView)
        binding.btnPartnersList.setOnClickListener(this::showListView)
    }

    private fun setFilterAdapter() {
        binding.recycFilter.adapter = PartnersFiltersAdapter(partnersListSubFragmentInstance,layoutInflater,requireContext(),listOf(
            FilterModel(R.drawable.ic_map_location,"Location"),
            FilterModel(R.drawable.ic_filter,"Filter"),
            FilterModel(R.drawable.ic_show_list,"List")
        ))
        binding.recycFilter.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
    }

    private fun moveToFilterFragment(view:View) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.partners_activity_container_view, FilterFragment())
            .addToBackStack("")
            .commit()
    }

    private fun showMapView(view: View) {
        if(!PartnersMapSubFragment().isVisible){
            setFocusBackground(binding.btnPartnersMap,binding.btnPartnersList)
            childFragmentManager.beginTransaction()
                .replace(R.id.partners_container_view, PartnersMapSubFragment())
                .commit()
        }
    }

    private fun setFocusBackground(toBeSoftYellow: ImageView, toBeGrey: ImageView) {
        toBeSoftYellow.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.soft_yellow))
        toBeGrey.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.grey))
    }

    private fun showListView(view:View) {
        if(!PartnersListSubFragment().isVisible){
            setFocusBackground(binding.btnPartnersList,binding.btnPartnersMap)
            childFragmentManager.beginTransaction()
                .replace(R.id.partners_container_view, partnersListSubFragmentInstance)
                .commit()
        }
    }


}
