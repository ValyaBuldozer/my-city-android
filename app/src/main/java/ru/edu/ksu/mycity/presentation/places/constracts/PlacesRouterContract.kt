package ru.edu.ksu.mycity.presentation.places.constracts

import ru.edu.ksu.mycity.entity.presentation.PlaceInfo
import ru.edu.ksu.mycity.helpers.arch.contracts.AndroidComponent
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperRouter

interface PlacesRouterContract {

    interface Presenter : ViperRouter.Listener { }

    interface Router : ViperRouter<Presenter> {
        fun showPlaceDetailInfo(androidComponent: AndroidComponent, placeInfo: PlaceInfo)
    }
}