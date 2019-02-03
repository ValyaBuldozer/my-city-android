package ru.edu.ksu.mycity.presentation.detail.place.contracts

import android.arch.lifecycle.MutableLiveData
import ru.edu.ksu.mycity.entity.presentation.Place
import ru.edu.ksu.mycity.entity.presentation.RouteInfo
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperPresenter
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel.State

interface DetailPlaceVmContract {

    interface ViewModel : ViperViewModel {

        var state: MutableLiveData<State>

        var errorMessage: MutableLiveData<String?>

        var showDescription: MutableLiveData<Boolean>

        var placeTitle: MutableLiveData<String?>

        var placeImagePath: MutableLiveData<String?>

        var placeDescription: MutableLiveData<String?>

        var placeRoutes: MutableLiveData<List<RouteInfo>?>
        
    }

    interface Presenter : ViperPresenter<ViewModel> {

        fun onShowDescriptionClick()

    }
}