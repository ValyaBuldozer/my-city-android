package ru.edu.ksu.mycity.presentation.routes.contracts

import androidx.lifecycle.MutableLiveData
import ru.edu.ksu.mycity.entity.presentation.RouteInfo
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperPresenter
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel.State

interface RoutesVmContract {

    interface ViewModel : ViperViewModel {

        var state: MutableLiveData<State>

        var errorMessage: MutableLiveData<String?>

        var routes: MutableLiveData<List<RouteInfo>>
    }

    interface Presenter : ViperPresenter<ViewModel> {
        fun onRouteSelected(routeInfo: RouteInfo)
    }
}