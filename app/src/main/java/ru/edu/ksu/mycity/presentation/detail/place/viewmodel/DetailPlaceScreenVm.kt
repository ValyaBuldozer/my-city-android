package ru.edu.ksu.mycity.presentation.detail.place.viewmodel

import androidx.lifecycle.MutableLiveData
import ru.edu.ksu.mycity.entity.presentation.Answer
import ru.edu.ksu.mycity.entity.presentation.Place
import ru.edu.ksu.mycity.entity.presentation.RouteInfo
import ru.edu.ksu.mycity.helpers.arch.base.BaseViewModel
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel.State
import ru.edu.ksu.mycity.presentation.detail.place.contracts.DetailPlaceVmContract

class DetailPlaceScreenVm : BaseViewModel(), DetailPlaceVmContract.ViewModel {

    override var state: MutableLiveData<State> =
        MutableLiveData<State>().apply { value = State.INITIAL }

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

    override var placeQuizTitle: MutableLiveData<String?> =
        MutableLiveData<String?>().apply { value = "" }

    override var placeQuizAnswers: MutableLiveData<List<Answer>?> =
        MutableLiveData<List<Answer>?>().apply { value = emptyList() }

    override var currentAnswer: MutableLiveData<Answer?> =
        MutableLiveData<Answer?>().apply { value = null }
}