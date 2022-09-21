package com.example.cashback.fragment.subfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cashback.partners_adapter.PartnersListAdapter
import az.expressbank.e24.models.partnersmodel.PartnersSubFragmentModel
import com.example.cashback.R
import com.example.cashback.databinding.SubfragmentPartnersListBinding
import com.example.cashback.fragment.CashBackDetailsFragment


interface FragmentChanger{
    fun changeFragment()
}


interface TitleChanger{
    fun changeTitle(title:String)
}


class PartnersListSubFragment : Fragment(), TitleChanger,FragmentChanger {
    private val binding by lazy{
        SubfragmentPartnersListBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAdapter()
    }

    private fun setAdapter() {
        binding.recyclerItem.adapter = PartnersListAdapter(this,listOf(
            PartnersSubFragmentModel(R.drawable.ic_show_list,"Schafer Azerbaijan","Other shops and services",4),
            PartnersSubFragmentModel(R.drawable.ic_show_list,"166 yukdasima ve logistika","Other shops and services",4),
        ))

        binding.recyclerItem.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }

    override fun changeTitle(title: String) {
        binding.partnersCategoryText.text = title
    }

    override fun changeFragment() {
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.partners_activity_container_view,CashBackDetailsFragment())
            .addToBackStack("")
            .commit()
    }


}