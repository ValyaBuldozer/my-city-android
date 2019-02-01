package ru.edu.ksu.mycity.presentation.routes.contracts

import ru.edu.ksu.mycity.entity.presentation.Route
import ru.edu.ksu.mycity.helpers.arch.contracts.AndroidComponent
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperRouter

interface RoutesRouterContract {

    interface Router : ViperRouter<Presenter> {

        fun showRouteInfo(androidComponent: AndroidComponent, route: Route)
    }

    interface Presenter : ViperRouter.Listener {

    }
}