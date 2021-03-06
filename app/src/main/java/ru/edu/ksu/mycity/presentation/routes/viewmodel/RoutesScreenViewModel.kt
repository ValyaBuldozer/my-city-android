package ru.edu.ksu.mycity.presentation.routes.viewmodel

import androidx.lifecycle.MutableLiveData
import ru.edu.ksu.mycity.entity.presentation.RouteInfo
import ru.edu.ksu.mycity.helpers.arch.base.BaseViewModel
import ru.edu.ksu.mycity.presentation.routes.contracts.RoutesVmContract
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel.State

class RoutesScreenViewModel() : BaseViewModel(), RoutesVmContract.ViewModel {
    override var state: MutableLiveData<State> =
        MutableLiveData<State>().apply { value = State.INITIAL }

    override var errorMessage: MutableLiveData<String?> =
        MutableLiveData<String?>().apply { value = "" }

    override var routes: MutableLiveData<List<RouteInfo>> =
        MutableLiveData<List<RouteInfo>>().apply { value = emptyList() }
}