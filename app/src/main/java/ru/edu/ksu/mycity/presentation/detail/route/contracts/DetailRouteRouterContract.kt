package ru.edu.ksu.mycity.presentation.detail.route.contracts

import android.net.RouteInfo
import ru.edu.ksu.mycity.helpers.arch.contracts.AndroidComponent
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperRouter

interface DetailRouteRouterContract {

    interface Presenter : ViperRouter.Listener {}

    interface Router : ViperRouter<Presenter> {
    }
}