package az.expressbank.e24.fragments.partners.subfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import az.expressbank.e24.adapters.partners_adapter.PartnersListAdapter
import az.expressbank.e24.models.partnersmodel.PartnersSubFragmentModel
import com.example.cashback.R
import com.example.cashback.databinding.SubfragmentPartnersListBinding

class PartnersListSubFragment : Fragment() {
    private val binding by lazy{
        SubfragmentPartnersListBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        setAdapter()
        return binding.root
    }

    private fun setAdapter() {
        binding.recyclerItem.adapter = PartnersListAdapter(listOf(
            PartnersSubFragmentModel(R.drawable.ic_show_list,"Schafer Azerbaijan","Other shops and services",4),
            PartnersSubFragmentModel(R.drawable.ic_show_list,"166 yukdasima ve logistika","Other shops and services",4),
        ))

        binding.recyclerItem.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }


}