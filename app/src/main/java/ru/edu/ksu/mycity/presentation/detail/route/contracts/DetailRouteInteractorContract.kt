package ru.edu.ksu.mycity.presentation.detail.route.contracts

import ru.edu.ksu.mycity.entity.presentation.Place
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperInteractor
import ru.edu.ksu.mycity.presentation.routes.contracts.RoutesInteractorContract

interface DetailRouteInteractorContract {

    interface Presenter : ViperInteractor.Listener {
        fun obtainedRoutePlace(place: Place?, error: Throwable?)
    }

    interface Interactor : ViperInteractor<Presenter> {
        fun obtainRoutePlace(placeId: Int)
    }
}