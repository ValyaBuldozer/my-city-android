package ru.edu.ksu.mycity.helpers.view.extensions.linearlayout

import android.content.Context
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.widget.LinearLayout
import ru.edu.ksu.mycity.R
import ru.edu.ksu.mycity.databinding.ItemDefaultBinding
import ru.edu.ksu.mycity.entity.presentation.RouteInfo

@BindingAdapter(value = ["routes_list", "route_click_handler"], requireAll = true)
fun LinearLayout.bindRoutesList(routes: List<RouteInfo>, clickHandler: (routeInfo : RouteInfo) -> Unit) {

    this.removeAllViews()

    val layoutInflater = (this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)) as LayoutInflater

    routes.forEach { routeInfo ->

        DataBindingUtil.inflate<ItemDefaultBinding>(
            layoutInflater,
            R.layout.item_default,
            this,
            true
        ).apply {
            imagePath = routeInfo.imagePath
            title = routeInfo.name
            setOnClickListener {
                clickHandler(routeInfo)
            }
        }
    }
}