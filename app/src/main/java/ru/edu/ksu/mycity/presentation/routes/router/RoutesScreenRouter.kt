package ru.edu.ksu.mycity.presentation.routes.router

import ru.edu.ksu.mycity.entity.presentation.RouteInfo
import ru.edu.ksu.mycity.helpers.arch.base.BaseRouter
import ru.edu.ksu.mycity.helpers.arch.contracts.AndroidComponent
import ru.edu.ksu.mycity.presentation.detail.route.view.DetailRouteScreenActivity
import ru.edu.ksu.mycity.presentation.routes.contracts.RoutesRouterContract

class RoutesScreenRouter : RoutesRouterContract.Router, BaseRouter<RoutesRouterContract.Presenter>() {
    override fun showRouteInfo(androidComponent: AndroidComponent, routeInfo: RouteInfo) {
        val activity = androidComponent.activity
        val intent = DetailRouteScreenActivity.createIntent(activity, routeInfo)
        activity.startActivity(intent)
    }

}