package com.example.cashback.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cashback.partners_adapter.PartnersFiltersAdapter
import az.expressbank.e24.fragments.partners.subfragments.PartnersListSubFragment
import az.expressbank.e24.models.partnersmodel.FilterModel
import com.example.cashback.R
import com.example.cashback.databinding.FragmentPartnersBinding
import com.example.e24_mobile_new.fragment.subfragments.PartnersMapSubFragment

class PartnersFragment : Fragment() {
    private val binding by lazy {
        FragmentPartnersBinding.inflate(layoutInflater)
    }

    private val mFragmentManager by lazy {
        childFragmentManager
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        Log.d("MyTagHere", "onCreateView: ")
        setFilterAdapter()
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.iconFilter.setOnClickListener(this::moveToFilterFragment)
        binding.btnPartnersMap.setOnClickListener(this::showMapView)
        binding.btnPartnersList.setOnClickListener(this::showListView)
    }

    private fun setFilterAdapter() {
        binding.recycFilter.adapter = PartnersFiltersAdapter(requireContext(),listOf(
            FilterModel(R.drawable.ic_map_location,"Location"),
            FilterModel(R.drawable.ic_filter,"Filter"),
            FilterModel(R.drawable.ic_show_list,"List")
        ))
        binding.recycFilter.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
    }

    private fun moveToFilterFragment(view:View) {
        //TODO change to the Filter Fragment
    }

    private fun showMapView(view: View) {
        if(!PartnersMapSubFragment().isVisible){
            mFragmentManager.beginTransaction()
                .replace(R.id.partners_container_view, PartnersMapSubFragment())
                .commit()
        }
    }

    private fun showListView(view:View) {
        if(!PartnersListSubFragment().isVisible){
            mFragmentManager.beginTransaction()
                .replace(R.id.partners_container_view,PartnersListSubFragment())
                .commit()
        }
    }


}
