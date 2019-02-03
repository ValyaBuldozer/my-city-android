package ru.edu.ksu.mycity.presentation.detail.place.contracts

import ru.edu.ksu.mycity.helpers.arch.contracts.ViperRouter

interface DetailPlaceRouterContract {

    interface Presenter : ViperRouter.Listener {

    }

    interface Router : ViperRouter<Presenter> {
        fun backToPlacesList()
    }
}