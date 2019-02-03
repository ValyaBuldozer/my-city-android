package ru.edu.ksu.mycity.presentation.detail.place.viewmodel

import android.arch.lifecycle.MutableLiveData
import ru.edu.ksu.mycity.entity.presentation.Place
import ru.edu.ksu.mycity.helpers.arch.base.BaseViewModel
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel.State
import ru.edu.ksu.mycity.presentation.detail.place.contracts.DetailPlaceVmContract

class DetailPlaceScreenVm : BaseViewModel(), DetailPlaceVmContract.ViewModel {

    override var state: MutableLiveData<ViperViewModel.State> =
        MutableLiveData<State>().apply { value = State.INITIAL }

    override var errorMessage: MutableLiveData<String?> =
        MutableLiveData<String?>().apply { value = "" }

    override var place: MutableLiveData<Place?> =
        MutableLiveData<Place?>().apply { value = null }

    override var showDescription: MutableLiveData<Boolean> =
        MutableLiveData<Boolean>().apply { value = false }
}