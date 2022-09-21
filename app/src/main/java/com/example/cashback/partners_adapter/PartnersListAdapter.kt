package com.example.cashback.partners_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import az.expressbank.e24.models.partnersmodel.PartnersSubFragmentModel
import com.example.cashback.R
import com.example.cashback.fragment.subfragments.FragmentChanger

class PartnersListAdapter(private val fragmentChangerInstance:FragmentChanger,private val partnersSubItems:List<PartnersSubFragmentModel>) : RecyclerView.Adapter<PartnersListAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        private val company: TextView = itemView.findViewById(R.id.subItemList_company)
        private val explanation: TextView = itemView.findViewById(R.id.subItemList_explanation)
        private val image: ImageView = itemView.findViewById(R.id.subItemList_image)
        private val percentage: TextView = itemView.findViewById(R.id.subItemList_percentage)
        private val generalItem: ConstraintLayout = itemView.findViewById(R.id.sublayout_partners_item_constraint)

        fun setItems(items: PartnersSubFragmentModel) {
            company.text = items.company
            explanation.text = items.explanation
            image.setBackgroundResource(items.image)
            percentage.text = "${items.percentage}%"
        }

        fun setListeners() {
            generalItem.setOnClickListener {
                fragmentChangerInstance.changeFragment()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sublayout_partners_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setItems(partnersSubItems[position])
        holder.setListeners()
    }

    override fun getItemCount(): Int = partnersSubItems.size
}


