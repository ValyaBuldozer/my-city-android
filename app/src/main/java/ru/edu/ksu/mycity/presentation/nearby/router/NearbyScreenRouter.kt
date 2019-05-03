package ru.edu.ksu.mycity.presentation.nearby.router

import ru.edu.ksu.mycity.entity.presentation.PlaceInfo
import ru.edu.ksu.mycity.helpers.arch.base.BaseRouter
import ru.edu.ksu.mycity.helpers.arch.contracts.AndroidComponent
import ru.edu.ksu.mycity.presentation.detail.place.view.DetailPlaceScreenActivity
import ru.edu.ksu.mycity.presentation.home.view.HomeActivity
import ru.edu.ksu.mycity.presentation.places.constracts.PlacesRouterContract

class NearbyScreenRouter : PlacesRouterContract.Router, BaseRouter<PlacesRouterContract.Presenter>() {
    override fun showPlaceDetailInfo(androidComponent: AndroidComponent, placeInfo: PlaceInfo) {
        val activity = androidComponent.activity
        val intent = DetailPlaceScreenActivity.createIntent(activity, placeInfo.id)
        activity.startActivity(intent)
    }

    override fun showHome(androidComponent: AndroidComponent) {
        val activity = androidComponent.activity
        val intent = HomeActivity.createIntent(activity)
        activity.startActivity(intent)
    }
}