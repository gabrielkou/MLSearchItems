package com.gabrielkou.ml.search

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.gabrielkou.ml.R
import com.gabrielkou.ml.model.ItemViewModel
import com.gabrielkou.presentation.model.ItemView
import javax.inject.Inject

class SearchItemsAdapter @Inject constructor(): RecyclerView.Adapter<SearchItemsAdapter.ViewHolder>() {

    var items : List<ItemViewModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_search, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleText.text = (items[position].title)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var titleText:TextView
        init {
            titleText = view.findViewById(R.id.text_title)
        }

    }
}