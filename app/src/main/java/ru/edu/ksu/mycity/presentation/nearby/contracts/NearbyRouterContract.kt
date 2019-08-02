package ru.edu.ksu.mycity.presentation.nearby.constracts

import ru.edu.ksu.mycity.entity.presentation.PlaceInfo
import ru.edu.ksu.mycity.helpers.arch.contracts.AndroidComponent
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperRouter

interface NearbyRouterContract {

    interface Presenter : ViperRouter.Listener { }

    interface Router : ViperRouter<Presenter> {
        fun showPlaceDetailInfo(androidComponent: AndroidComponent, placeInfo: PlaceInfo)

        fun showHome(androidComponent: AndroidComponent)
    }
}