package ru.edu.ksu.mycity.presentation.detail.place.contracts

import ru.edu.ksu.mycity.entity.presentation.RouteInfo
import ru.edu.ksu.mycity.helpers.arch.contracts.AndroidComponent
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperRouter

interface DetailPlaceRouterContract {

    interface Presenter : ViperRouter.Listener {

    }

    interface Router : ViperRouter<Presenter> {
        fun backToPlacesList(androidComponent: AndroidComponent)

        fun showRoutePlace(androidComponent: AndroidComponent, routeInfo: RouteInfo, placeId: Int)
    }
}