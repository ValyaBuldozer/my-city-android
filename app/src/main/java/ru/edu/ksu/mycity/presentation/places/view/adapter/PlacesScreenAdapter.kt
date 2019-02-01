package ru.edu.ksu.mycity.presentation.places.view.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.edu.ksu.mycity.R
import ru.edu.ksu.mycity.databinding.ItemDefaultBinding
import ru.edu.ksu.mycity.entity.presentation.Place
import ru.edu.ksu.mycity.helpers.presentation.BaseAdapter

class PlacesScreenAdapter(val clickListener: (place: Place) -> Unit) : BaseAdapter<PlacesScreenAdapter.ViewHolder, Place>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        DataBindingUtil.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.item_default, parent, false)
        )!!
    )

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val place = itemsList[position]
        viewHolder.bindView.root.setOnClickListener { clickListener(place) }
        viewHolder.bind(place)
    }

    class ViewHolder(val bindView: ItemDefaultBinding) : RecyclerView.ViewHolder(bindView.root) {

        fun bind(place: Place) {
            with(bindView){
                this.title = place.name
                this.imagePath = place.logoImagePath
                executePendingBindings()
            }
        }
    }
}