package ru.edu.ksu.mycity.presentation.detail.route.router

import ru.edu.ksu.mycity.entity.presentation.RouteInfo
import ru.edu.ksu.mycity.helpers.arch.base.BaseRouter
import ru.edu.ksu.mycity.helpers.arch.contracts.AndroidComponent
import ru.edu.ksu.mycity.presentation.detail.route.contracts.DetailRouteRouterContract
import ru.edu.ksu.mycity.presentation.detail.route.view.DetailRouteScreenActivity

class DetailRoutesScreenRouter : BaseRouter<DetailRouteRouterContract.Presenter>(),
    DetailRouteRouterContract.Router {

    override fun showRouteDetail(androidComponent: AndroidComponent, routeInfo: RouteInfo) {
        val activity = androidComponent.activity
        val intent = DetailRouteScreenActivity.createIntent(activity, routeInfo)
        activity.startActivity(intent)
    }
}