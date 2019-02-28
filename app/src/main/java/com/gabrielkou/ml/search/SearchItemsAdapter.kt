package com.gabrielkou.ml.search

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gabrielkou.ml.R
import com.gabrielkou.ml.model.ItemViewModel
import com.gabrielkou.presentation.model.ItemView
import javax.inject.Inject

class SearchItemsAdapter @Inject constructor(): RecyclerView.Adapter<SearchItemsAdapter.ViewHolder>() {

    var items : List<ItemViewModel> = arrayListOf()
    var itemListener: ItemListener? = null

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
        var item = items[position]
        holder.titleText.text = item.title

        Glide.with(holder.itemView.context)
            .load(item.imageUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.thumbnail)

        holder.itemView.setOnClickListener {
            itemListener?.onItemClicked(item.id)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var titleText:TextView
        var thumbnail: ImageView
        init {
            titleText = view.findViewById(R.id.item_title)
            thumbnail = view.findViewById(R.id.item_thumbnail)
        }

    }
}