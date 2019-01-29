package ru.edu.ksu.mycity.presentation.routes.contracts

import ru.edu.ksu.mycity.entity.presentation.Route
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperInteractor

interface RoutesInteractorContract {

    interface Presenter : ViperInteractor.Listener {
        fun obtainedRoutes(data: List<Route>, error: Throwable?)
    }

    interface Interactor : ViperInteractor<Presenter> {
        fun obtainRoutes()
    }
}