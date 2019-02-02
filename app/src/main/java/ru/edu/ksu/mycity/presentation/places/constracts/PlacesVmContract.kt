package ru.edu.ksu.mycity.presentation.places.constracts

import android.arch.lifecycle.MutableLiveData
import ru.edu.ksu.mycity.entity.presentation.PlaceInfo
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperPresenter
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel

interface PlacesVmContract {

    interface ViewModel : ViperViewModel {

        enum class State {
            INITIAL, LOADING, DATA,ERROR
        }

        var state: MutableLiveData<State>

        var errorMessage: MutableLiveData<String?>

        var places: MutableLiveData<List<PlaceInfo>>

    }

    interface Presenter : ViperPresenter<ViewModel> {
        fun onPlaceSelected(placeInfo: PlaceInfo)
    }
}