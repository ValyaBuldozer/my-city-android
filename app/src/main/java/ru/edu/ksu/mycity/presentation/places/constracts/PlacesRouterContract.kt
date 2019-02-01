package ru.edu.ksu.mycity.presentation.places.constracts

import ru.edu.ksu.mycity.entity.presentation.Place
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperRouter

interface PlacesRouterContract {

    interface Presenter : ViperRouter.Listener { }

    interface Router : ViperRouter<Presenter> {
        fun showPlaceDetailInfo(place: Place)
    }
}