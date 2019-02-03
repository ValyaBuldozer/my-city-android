package ru.edu.ksu.mycity.presentation.detail.place.presenter

import ru.edu.ksu.mycity.entity.presentation.Place
import ru.edu.ksu.mycity.helpers.arch.base.BasePresenter
import ru.edu.ksu.mycity.helpers.arch.contracts.AndroidComponent
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel.State
import ru.edu.ksu.mycity.presentation.detail.place.contracts.DetailPlaceInteractorContract
import ru.edu.ksu.mycity.presentation.detail.place.contracts.DetailPlaceRouterContract
import ru.edu.ksu.mycity.presentation.detail.place.contracts.DetailPlaceVmContract

class DetailPlaceScreenPresenter(
    val interactor: DetailPlaceInteractorContract.Interactor,
    val router: DetailPlaceRouterContract.Router,
    private val placeId: Int
) : BasePresenter<DetailPlaceVmContract.ViewModel>(),
    DetailPlaceInteractorContract.Presenter,
    DetailPlaceRouterContract.Presenter,
    DetailPlaceVmContract.Presenter {

    override fun attachView(viewModel: DetailPlaceVmContract.ViewModel, component: AndroidComponent) {
        super.attachView(viewModel, component)
        interactor.listener = this

        if (vm.state.value == State.INITIAL) {
            vm.state.value = State.LOADING
            interactor.obtainPlaceDetail(placeId)
        }
    }

    override fun detachView() {
        super.detachView()
        interactor.listener = null
    }

    override fun obtainedPlaceDetail(place: Place?, error: Throwable?) {
        if (error == null) {
            vm.state.value = State.DATA
            vm.place.value = place
        } else {
            vm.state.value = State.ERROR
            vm.place.value = null
        }
    }

    override fun onShowDescriptionClick() {
        vm.showDescription.value = vm.showDescription.value != true
    }
}