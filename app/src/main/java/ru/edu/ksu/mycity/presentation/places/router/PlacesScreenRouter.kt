package ru.edu.ksu.mycity.presentation.places.router

import ru.edu.ksu.mycity.entity.presentation.PlaceInfo
import ru.edu.ksu.mycity.helpers.arch.base.BaseRouter
import ru.edu.ksu.mycity.helpers.arch.contracts.AndroidComponent
import ru.edu.ksu.mycity.presentation.detail.place.view.DetailPlaceScreenActivity
import ru.edu.ksu.mycity.presentation.places.constracts.PlacesRouterContract

class PlacesScreenRouter : PlacesRouterContract.Router, BaseRouter<PlacesRouterContract.Presenter>() {
    override fun showPlaceDetailInfo(androidComponent: AndroidComponent, placeInfo: PlaceInfo) {
        val activity = androidComponent.activity
        val intent = DetailPlaceScreenActivity.createIntent(activity, placeInfo.id)
        activity.startActivity(intent)
    }
}