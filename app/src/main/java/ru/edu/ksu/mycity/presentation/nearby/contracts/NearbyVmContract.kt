package ru.edu.ksu.mycity.presentation.nearby.constracts

import androidx.lifecycle.MutableLiveData
import ru.edu.ksu.mycity.entity.presentation.PlaceInfo
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperPresenter
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel

interface NearbyVmContract {

    interface ViewModel : ViperViewModel {

        var state: MutableLiveData<ViperViewModel.State>

        var errorMessage: MutableLiveData<String?>

        var places: MutableLiveData<List<PlaceInfo>>

    }

    interface Presenter : ViperPresenter<ViewModel> {
        fun onPlaceSelected(placeInfo: PlaceInfo)

        fun onGoBack()
    }
}