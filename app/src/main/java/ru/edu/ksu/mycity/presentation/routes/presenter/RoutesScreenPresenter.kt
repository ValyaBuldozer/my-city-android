package ru.edu.ksu.mycity.presentation.routes.presenter

import android.util.Log
import ru.edu.ksu.mycity.entity.presentation.RouteInfo
import ru.edu.ksu.mycity.helpers.arch.base.BasePresenter
import ru.edu.ksu.mycity.helpers.arch.contracts.AndroidComponent
import ru.edu.ksu.mycity.presentation.routes.contracts.RoutesInteractorContract
import ru.edu.ksu.mycity.presentation.routes.contracts.RoutesRouterContract
import ru.edu.ksu.mycity.presentation.routes.contracts.RoutesVmContract
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel.State

class RoutesScreenPresenter(
    val interactor: RoutesInteractorContract.Interactor,
    val router: RoutesRouterContract.Router
) : BasePresenter<RoutesVmContract.ViewModel>(),
    RoutesInteractorContract.Presenter,
    RoutesVmContract.Presenter,
    RoutesRouterContract.Presenter {

    override fun attachView(viewModel: RoutesVmContract.ViewModel, component: AndroidComponent) {
        super.attachView(viewModel, component)
        interactor.listener = this

        if (vm.state.value == State.INITIAL) {
            vm.state.value = State.LOADING
            interactor.obtainRoutes()
        }
    }

    override fun detachView() {
        interactor.listener = null
        super.detachView()
    }

    override fun obtainedRoutes(data: List<RouteInfo>, error: Throwable?) {
        if (error == null) {
            vm.state.value = State.DATA
            vm.routes.value = data
        } else {
            vm.state.value = State.ERROR
            vm.errorMessage.value = error.message
            // TODO(REMOVE LOG)
            Log.e("HANDLER_ERROR", "Exception during routes request", error)
        }
    }

    override fun onRouteSelected(routeInfo: RouteInfo) {
        router.showRouteInfo(androidComponent!!, routeInfo, routeInfo.places.first())
    }

}