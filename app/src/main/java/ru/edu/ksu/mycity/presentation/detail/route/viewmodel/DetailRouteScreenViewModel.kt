package ru.edu.ksu.mycity.presentation.detail.route.viewmodel

import android.arch.lifecycle.MutableLiveData
import ru.edu.ksu.mycity.entity.presentation.RouteInfo
import ru.edu.ksu.mycity.helpers.arch.base.BaseViewModel
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel.State
import ru.edu.ksu.mycity.presentation.detail.route.contracts.DetailRouteVmContract

class DetailRouteScreenViewModel : BaseViewModel(), DetailRouteVmContract.ViewModel {

    override var state: MutableLiveData<ViperViewModel.State> =
        MutableLiveData<ViperViewModel.State>().apply { value = State.INITIAL }

    override var errorMessage: MutableLiveData<String?> =
        MutableLiveData<String?>().apply { value = "" }

    override var showDescription: MutableLiveData<Boolean> =
        MutableLiveData<Boolean>().apply { value = false }

    override var placeTitle: MutableLiveData<String?> =
        MutableLiveData<String?>().apply { value = "" }

    override var placeImagePath: MutableLiveData<String?> =
        MutableLiveData<String?>().apply { value = "" }

    override var placeDescription: MutableLiveData<String?> =
        MutableLiveData<String?>().apply { value = "" }

    override var placeRoutes: MutableLiveData<List<RouteInfo>?> =
        MutableLiveData<List<RouteInfo>?>().apply { value = emptyList() }
}