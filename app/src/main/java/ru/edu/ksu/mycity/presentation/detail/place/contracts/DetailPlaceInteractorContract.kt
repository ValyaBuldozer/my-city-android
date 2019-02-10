package ru.edu.ksu.mycity.presentation.detail.place.contracts

import ru.edu.ksu.mycity.entity.presentation.Place
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperInteractor

interface DetailPlaceInteractorContract {

    interface Presenter : ViperInteractor.Listener {
        fun obtainedPlaceDetail(place: Place?, error: Throwable?)
    }

    interface Interactor : ViperInteractor<Presenter> {
        fun obtainPlaceDetail(placeId: Int)
    }
}