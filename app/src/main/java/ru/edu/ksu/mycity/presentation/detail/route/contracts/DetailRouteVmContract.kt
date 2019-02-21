package ru.edu.ksu.mycity.presentation.detail.route.contracts


import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import ru.edu.ksu.mycity.entity.presentation.RouteInfo
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperPresenter
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel.State

interface DetailRouteVmContract {

    interface ViewModel : ViperViewModel {

        var state : MutableLiveData<State>

        var errorMessage : MutableLiveData<String?>

        var showDescription : MutableLiveData<Boolean>

        var routeTitle : MutableLiveData<String>

        var placeId : MutableLiveData<Int>

        var placeTitle : MutableLiveData<String?>

        var placeImagePath : MutableLiveData<String?>

        var placeDescription : MutableLiveData<String?>

        var placeRoutes : MutableLiveData<List<RouteInfo>?>

        var nextBtnEnabled : MediatorLiveData<Boolean>

        var prevBtnEnabled : MediatorLiveData<Boolean>

    }

    interface Presenter : ViperPresenter<ViewModel> {

        fun onShowDescriptionClick()

        fun onShowRouteClick(routeInfo: RouteInfo)

        fun nextPlaceHandler()

        fun prevPlaceHandler()

    }
}