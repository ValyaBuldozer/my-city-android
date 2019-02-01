package ru.edu.ksu.mycity.presentation.routes.router

import ru.edu.ksu.mycity.entity.presentation.Route
import ru.edu.ksu.mycity.helpers.arch.base.BaseRouter
import ru.edu.ksu.mycity.helpers.arch.contracts.AndroidComponent
import ru.edu.ksu.mycity.presentation.routes.contracts.RoutesRouterContract

class RoutesScreenRouter : RoutesRouterContract.Router, BaseRouter<RoutesRouterContract.Presenter>() {
    override fun showRouteInfo(androidComponent: AndroidComponent, route: Route) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}