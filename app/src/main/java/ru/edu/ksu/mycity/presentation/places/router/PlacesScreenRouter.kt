package ru.edu.ksu.mycity.presentation.places.router

import ru.edu.ksu.mycity.entity.presentation.Place
import ru.edu.ksu.mycity.helpers.arch.base.BaseRouter
import ru.edu.ksu.mycity.presentation.places.constracts.PlacesRouterContract

class PlacesScreenRouter : PlacesRouterContract.Router, BaseRouter<PlacesRouterContract.Presenter>() {
    override fun showPlaceDetailInfo(place: Place) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}