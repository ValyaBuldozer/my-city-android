package ru.edu.ksu.mycity.presentation.routes.view.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.edu.ksu.mycity.R
import ru.edu.ksu.mycity.databinding.ItemRouteBinding
import ru.edu.ksu.mycity.entity.presentation.RouteInfo
import ru.edu.ksu.mycity.helpers.presentation.BaseAdapter

class RoutesScreenAdapter(val clickListener: (RouteInfo) -> Unit ) : BaseAdapter<RoutesScreenAdapter.ViewHolder, RouteInfo>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            DataBindingUtil.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.item_route, parent, false)
            )!!
        )

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val route = itemsList[position]
        viewHolder.bindView.root.setOnClickListener { clickListener(route) }
        viewHolder.bind(route)
    }


    class ViewHolder(val bindView: ItemRouteBinding) : RecyclerView.ViewHolder(bindView.root) {

        fun bind(viewModel: RouteInfo) {
            with(bindView) {
                this.viewModel = viewModel
                executePendingBindings()
            }
        }
    }
}