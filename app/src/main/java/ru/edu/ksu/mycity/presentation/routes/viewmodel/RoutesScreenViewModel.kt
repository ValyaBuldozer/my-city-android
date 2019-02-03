package ru.edu.ksu.mycity.presentation.routes.viewmodel

import android.arch.lifecycle.MutableLiveData
import ru.edu.ksu.mycity.entity.presentation.Route
import ru.edu.ksu.mycity.helpers.arch.base.BaseViewModel
import ru.edu.ksu.mycity.presentation.routes.contracts.RoutesVmContract
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel.State

class RoutesScreenViewModel() : BaseViewModel(), RoutesVmContract.ViewModel {
    override var state: MutableLiveData<State> =
        MutableLiveData<State>().apply { value = State.INITIAL }

    override var errorMessage: MutableLiveData<String?> =
        MutableLiveData<String?>().apply { value = "" }

    override var routes: MutableLiveData<List<Route>> =
        MutableLiveData<List<Route>>().apply { value = emptyList() }
}