package ru.edu.ksu.mycity.presentation.routes.contracts

import ru.edu.ksu.mycity.entity.presentation.RouteInfo
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperInteractor

interface RoutesInteractorContract {

    interface Presenter : ViperInteractor.Listener {
        fun obtainedRoutes(data: List<RouteInfo>, error: Throwable?)
    }

    interface Interactor : ViperInteractor<Presenter> {
        fun obtainRoutes()
    }
}