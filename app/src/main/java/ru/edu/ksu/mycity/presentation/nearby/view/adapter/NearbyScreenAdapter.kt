package ru.edu.ksu.mycity.presentation.nearby.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.edu.ksu.mycity.R
import ru.edu.ksu.mycity.databinding.ItemDefaultBinding
import ru.edu.ksu.mycity.databinding.ItemWithDescriptionBinding
import ru.edu.ksu.mycity.entity.presentation.PlaceInfo
import ru.edu.ksu.mycity.helpers.presentation.BaseAdapter

class NearbyScreenAdapter(val clickListener: (placeInfo: PlaceInfo) -> Unit) : BaseAdapter<NearbyScreenAdapter.ViewHolder, PlaceInfo>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        DataBindingUtil.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.item_with_description, parent, false)
        )!!
    )

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val place = itemsList[position]
        viewHolder.bindView.root.setOnClickListener { clickListener(place) }
        viewHolder.bind(place)
    }

    class ViewHolder(val bindView: ItemWithDescriptionBinding) : RecyclerView.ViewHolder(bindView.root) {

        fun bind(placeInfo: PlaceInfo) {
            with(bindView){
                this.title = placeInfo.name
                this.imagePath = placeInfo.logoImagePath
                this.description = ""
                executePendingBindings()
            }
        }


    }
}