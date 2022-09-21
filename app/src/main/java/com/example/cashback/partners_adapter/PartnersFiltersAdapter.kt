package com.example.cashback.partners_adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import az.expressbank.e24.models.partnersmodel.FilterModel
import com.example.cashback.R
import com.example.cashback.databinding.PartnersFilterItemBinding
import com.example.cashback.fragment.subfragments.TitleChanger
import com.google.android.material.card.MaterialCardView

class PartnersFiltersAdapter(private val titleChanger: TitleChanger, private val layoutInflater: LayoutInflater, private val context: Context, private val filterItems:List<FilterModel>): RecyclerView.Adapter<PartnersFiltersAdapter.ViewHolder>() {

    private lateinit var binding: PartnersFilterItemBinding
    private var selectedPoint = 0

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        private val filterImage: ImageView = itemView.findViewById(R.id.partners_item_imageView)
        private val filterText: TextView = itemView.findViewById(R.id.partners_item_textview)
        private val filterCardView: MaterialCardView = itemView.findViewById(R.id.partners_item_cardview)
        private val filterConstraint:ConstraintLayout = itemView.findViewById(R.id.partners_item_constraint)

        fun setFilterImage(resource:Int,position: Int){
            filterImage.setBackgroundResource(resource)
            if(selectedPoint!=position)
                filterCardView.setCardBackgroundColor(ContextCompat.getColor(context,R.color.grey))
            else
                filterCardView.setCardBackgroundColor(ContextCompat.getColor(context,R.color.soft_yellow))

        }

        fun setFilterText(text:String){
            filterText.text = text
        }

        fun setListeners(position:Int) {
            filterConstraint.setOnClickListener {
                changeClickStage(filterCardView, position)
                //TODO get interface instance to call titleChanger
                titleChanger.changeTitle(filterItems[position].filterText)
            }
        }
    }

    private fun changeClickStage(filterCardView:CardView, position: Int) {
        if(selectedPoint != position) {
            notifyItemChanged(selectedPoint)
            filterCardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.soft_yellow))
            Log.d("MyTagHere", "changeClickStage: ${filterCardView.cardBackgroundColor}")
            selectedPoint = position
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = PartnersFilterItemBinding.inflate(layoutInflater)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setFilterImage(filterItems[position].resource,position)
        holder.setFilterText(filterItems[position].filterText)
        holder.setListeners(position)
    }

    override fun getItemCount(): Int = filterItems.size
}