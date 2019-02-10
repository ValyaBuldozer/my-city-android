package ru.edu.ksu.mycity.presentation.detail.route.presenter

import android.util.Log
import ru.edu.ksu.mycity.entity.presentation.Place
import ru.edu.ksu.mycity.entity.presentation.RouteInfo
import ru.edu.ksu.mycity.helpers.arch.base.BasePresenter
import ru.edu.ksu.mycity.helpers.arch.contracts.AndroidComponent
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel.State
import ru.edu.ksu.mycity.presentation.detail.route.contracts.DetailRouteInteractorContract
import ru.edu.ksu.mycity.presentation.detail.route.contracts.DetailRouteRouterContract
import ru.edu.ksu.mycity.presentation.detail.route.contracts.DetailRouteVmContract

class DetailRouteScreenPresenter(
    val interactor: DetailRouteInteractorContract.Interactor,
    val router: DetailRouteRouterContract.Router,
    var placeId: Int,
    val routeInfo: RouteInfo
) : BasePresenter<DetailRouteVmContract.ViewModel>(),
    DetailRouteVmContract.Presenter,
    DetailRouteInteractorContract.Presenter,
    DetailRouteRouterContract.Presenter {

    override fun attachView(viewModel: DetailRouteVmContract.ViewModel, component: AndroidComponent) {
        super.attachView(viewModel, component)
        interactor.listener = this

        if (vm.state.value == State.INITIAL) {
            vm.state.value = State.LOADING
            interactor.obtainRoutePlace(placeId)
        }
    }

    override fun detachView() {
        interactor.listener = null
        super.detachView()
    }

    override fun onShowDescriptionClick() {
        vm.showDescription.value = vm.showDescription.value == false
    }

    override fun obtainedRoutePlace(place: Place?, error: Throwable?) {
        if (error == null && place != null) {
            placeId = place.id
            vm.apply {
                placeId.value = place.id
                placeTitle.value = place.name
                placeImagePath.value = place.backgroundImagePath
                placeDescription.value = place.description
                placeRoutes.value = place.routes
                state.value = State.DATA
            }
        } else {
            // TODO(REMOVE LOG)
            Log.e("HANDLER_ERROR", "Exception during routes request", error)
            vm.errorMessage.value = error.toString()
            vm.state.value = State.ERROR
        }
    }

    override fun nextPlaceHandler() {
        val nextPlaceIndex = routeInfo.places.indexOf(placeId) + 1

        if (nextPlaceIndex != routeInfo.places.size) {
            vm.state.value = State.LOADING
            interactor.obtainRoutePlace(routeInfo.places[nextPlaceIndex])
        }
    }

    override fun prevPlaceHandler() {
        val prevPlaceIndex = routeInfo.places.indexOf(placeId) - 1

        if (prevPlaceIndex != -1) {
            vm.state.value = State.LOADING
            interactor.obtainRoutePlace(routeInfo.places[prevPlaceIndex])
        }
    }

    override fun onShowRouteClick(routeInfo: RouteInfo) {
        router.showRouteDetail(androidComponent!!, routeInfo)
    }
}