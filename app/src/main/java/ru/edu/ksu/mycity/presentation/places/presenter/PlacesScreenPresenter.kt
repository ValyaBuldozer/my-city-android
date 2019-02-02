package ru.edu.ksu.mycity.presentation.places.presenter

import android.util.Log
import ru.edu.ksu.mycity.entity.presentation.PlaceInfo
import ru.edu.ksu.mycity.helpers.arch.base.BasePresenter
import ru.edu.ksu.mycity.helpers.arch.contracts.AndroidComponent
import ru.edu.ksu.mycity.presentation.places.constracts.PlacesInteractorContract
import ru.edu.ksu.mycity.presentation.places.constracts.PlacesRouterContract
import ru.edu.ksu.mycity.presentation.places.constracts.PlacesVmContract
import ru.edu.ksu.mycity.presentation.places.constracts.PlacesVmContract.ViewModel.State


class PlacesScreenPresenter(
    val interactor: PlacesInteractorContract.Interactor,
    val router: PlacesRouterContract.Router
) : BasePresenter<PlacesVmContract.ViewModel>(),
    PlacesInteractorContract.Presenter,
    PlacesRouterContract.Presenter,
    PlacesVmContract.Presenter {

    override fun attachView(viewModel: PlacesVmContract.ViewModel, component: AndroidComponent) {
        super.attachView(viewModel, component)
        interactor.listener = this

        if (vm.state.value == State.INITIAL) {
            vm.state.value = State.LOADING
            interactor.obtainPlaces()
        }
    }

    override fun detachView() {
        super.detachView()
        interactor.listener = null
    }


    override fun obtainedPlaces(placeInfos: List<PlaceInfo>, error: Throwable?) {
        if (error == null) {
            vm.state.value = State.DATA
            vm.places.value = placeInfos
        } else {
            vm.state.value = State.ERROR
            vm.places.value = emptyList()
            // TODO(REMOVE LOG)
            Log.e("HANDLED_ERROR", "Exception during placeInfos request", error)
        }
    }

    override fun onPlaceSelected(placeInfo: PlaceInfo) {
        router.showPlaceDetailInfo(placeInfo)
    }
}