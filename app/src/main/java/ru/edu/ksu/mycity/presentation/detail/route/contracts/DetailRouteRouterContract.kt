package ru.edu.ksu.mycity.presentation.detail.route.contracts

import ru.edu.ksu.mycity.helpers.arch.contracts.ViperRouter

interface DetailRouteRouterContract {

    interface Presenter : ViperRouter.Listener {}

    interface Router : ViperRouter<Presenter> {
        fun nextRoutePlace()

        fun prevRoutePlace()
    }
}