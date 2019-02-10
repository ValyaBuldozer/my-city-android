package ru.edu.ksu.mycity.presentation.places.constracts

import ru.edu.ksu.mycity.entity.presentation.PlaceInfo
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperInteractor

interface PlacesInteractorContract {

    interface Presenter : ViperInteractor.Listener {
        fun obtainedPlaces(placeInfos: List<PlaceInfo>, error: Throwable?)
    }

    interface Interactor : ViperInteractor<Presenter> {
        fun obtainPlaces()
    }
}