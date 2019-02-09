package ru.edu.ksu.mycity.presentation.routes.contracts

import ru.edu.ksu.mycity.entity.presentation.RouteInfo
import ru.edu.ksu.mycity.helpers.arch.contracts.AndroidComponent
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperRouter

interface RoutesRouterContract {

    interface Router : ViperRouter<Presenter> {
        fun showRouteInfo(androidComponent: AndroidComponent, routeInfo: RouteInfo)
    }

    interface Presenter : ViperRouter.Listener {}
}