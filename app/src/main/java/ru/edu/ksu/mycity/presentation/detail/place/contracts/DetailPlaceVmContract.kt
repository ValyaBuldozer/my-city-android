package ru.edu.ksu.mycity.presentation.detail.place.contracts

import androidx.lifecycle.MutableLiveData
import ru.edu.ksu.mycity.entity.presentation.Answer
import ru.edu.ksu.mycity.entity.presentation.Place
import ru.edu.ksu.mycity.entity.presentation.RouteInfo
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperPresenter
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel.State

interface DetailPlaceVmContract {

    interface ViewModel : ViperViewModel {

        var state: MutableLiveData<State>

        var errorMessage: MutableLiveData<String?>

        var showDescription: MutableLiveData<Boolean>

        var placeTitle: MutableLiveData<String?>

        var placeImagePath: MutableLiveData<String?>

        var placeDescription: MutableLiveData<String?>

        var placeRoutes: MutableLiveData<List<RouteInfo>?>

        var placeQuizTitle: MutableLiveData<String?>

        var placeQuizAnswers: MutableLiveData<List<Answer>?>

        var currentAnswer: MutableLiveData<Answer?>

    }

    interface Presenter : ViperPresenter<ViewModel> {

        fun onShowDescriptionClick()

        fun onRouteClick(routeInfo: RouteInfo)

        fun onQuizAnswerClick(answer: Answer)

    }
}