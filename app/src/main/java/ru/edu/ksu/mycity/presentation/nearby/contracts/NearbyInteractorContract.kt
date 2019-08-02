package ru.edu.ksu.mycity.presentation.nearby.constracts

import ru.edu.ksu.mycity.entity.presentation.PlaceInfo
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperInteractor

interface NearbyInteractorContract {

    interface Presenter : ViperInteractor.Listener {
        fun obtainedPlaces(placeInfos: List<PlaceInfo>, error: Throwable?)
    }

    interface Interactor : ViperInteractor<Presenter> {
        fun obtainPlaces()
    }
}