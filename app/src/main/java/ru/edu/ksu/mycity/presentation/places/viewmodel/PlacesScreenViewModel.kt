package ru.edu.ksu.mycity.presentation.places.viewmodel

import androidx.lifecycle.MutableLiveData
import ru.edu.ksu.mycity.entity.presentation.PlaceInfo
import ru.edu.ksu.mycity.helpers.arch.base.BaseViewModel
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel.State
import ru.edu.ksu.mycity.presentation.places.constracts.PlacesVmContract

class PlacesScreenViewModel : PlacesVmContract.ViewModel, BaseViewModel() {

    override var state: MutableLiveData<State> =
            MutableLiveData<State>().apply { value = State.INITIAL }

    override var errorMessage: MutableLiveData<String?> =
            MutableLiveData<String?>().apply { value = "" }

    override var places: MutableLiveData<List<PlaceInfo>> =
            MutableLiveData<List<PlaceInfo>>().apply { value = emptyList() }
}