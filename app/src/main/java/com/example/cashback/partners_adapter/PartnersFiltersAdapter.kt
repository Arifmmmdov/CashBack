package com.example.cashback.partners_adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import az.expressbank.e24.models.partnersmodel.FilterModel
import com.example.cashback.R

class PartnersFiltersAdapter(private val context: Context,private val filterItems:List<FilterModel>): RecyclerView.Adapter<PartnersFiltersAdapter.ViewHolder>() {

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        private val filterImage: ImageView = itemView.findViewById(R.id.partners_item_imageview)
        private val filterText: TextView = itemView.findViewById(R.id.partners_item_textview)
        private val filterCardView:CardView = itemView.findViewById(R.id.partners_item_cardview)

        init {
            filterCardView.setBackgroundColor(ContextCompat.getColor(context,R.color.grey))
        }
        fun setFilterImage(resource:Int){
            filterImage.setBackgroundResource(resource)
        }

        fun setFilterText(text:String){
            filterText.text = text
        }

        fun setListeners(context: Context) {
            filterCardView.setOnClickListener {
                this@PartnersFiltersAdapter.notifyItemRangeChanged(0,filterItems.size)
                it.setBackgroundColor(ContextCompat.getColor(context,R.color.swipe_rename_color))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("MyTagHere", "onCreateViewHolder:")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.partners_filter_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("MyTagHere", "onBindViewHolder: $position")
        holder.setFilterImage(filterItems[position].resource)
        holder.setFilterText(filterItems[position].filterText)
        holder.setListeners(context)
    }

    override fun getItemCount(): Int = filterItems.size
}