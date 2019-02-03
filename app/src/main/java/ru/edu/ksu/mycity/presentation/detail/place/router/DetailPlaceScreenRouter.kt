package ru.edu.ksu.mycity.presentation.detail.place.router

import ru.edu.ksu.mycity.helpers.arch.base.BaseRouter
import ru.edu.ksu.mycity.presentation.detail.place.contracts.DetailPlaceRouterContract

class DetailPlaceScreenRouter : BaseRouter<DetailPlaceRouterContract.Presenter>(),
    DetailPlaceRouterContract.Router {

    override fun backToPlacesList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}