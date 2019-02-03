package ru.edu.ksu.mycity.presentation.routes.contracts

import android.arch.lifecycle.MutableLiveData
import ru.edu.ksu.mycity.entity.presentation.Route
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperPresenter
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel.State

interface RoutesVmContract {

    interface ViewModel : ViperViewModel {

        var state: MutableLiveData<State>

        var errorMessage: MutableLiveData<String?>

        var routes: MutableLiveData<List<Route>>
    }

    interface Presenter : ViperPresenter<ViewModel> {
        fun onRouteSelected(route: Route)
    }
}