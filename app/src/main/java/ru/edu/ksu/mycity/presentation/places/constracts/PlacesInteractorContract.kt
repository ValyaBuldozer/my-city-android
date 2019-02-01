package ru.edu.ksu.mycity.presentation.places.constracts

import ru.edu.ksu.mycity.entity.presentation.Place
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperInteractor

interface PlacesInteractorContract {

    interface Presenter : ViperInteractor.Listener {
        fun obtainedPlaces(places: List<Place>, error: Throwable?)
    }

    interface Interactor : ViperInteractor<Presenter> {
        fun obtainPlaces()
    }
}