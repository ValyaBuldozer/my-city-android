package ru.edu.ksu.mycity.presentation.detail.place.router

import ru.edu.ksu.mycity.entity.presentation.RouteInfo
import ru.edu.ksu.mycity.helpers.arch.base.BaseRouter
import ru.edu.ksu.mycity.helpers.arch.contracts.AndroidComponent
import ru.edu.ksu.mycity.presentation.detail.place.contracts.DetailPlaceRouterContract
import ru.edu.ksu.mycity.presentation.detail.route.view.DetailRouteScreenActivity
import ru.edu.ksu.mycity.presentation.places.view.PlacesScreenActivity

class DetailPlaceScreenRouter : BaseRouter<DetailPlaceRouterContract.Presenter>(),
    DetailPlaceRouterContract.Router {

    override fun backToPlacesList(androidComponent: AndroidComponent) {
        val activity = androidComponent.activity
        val intent = PlacesScreenActivity.createIntent(activity)
        activity.startActivity(intent)
    }

    override fun showRoutePlace(androidComponent: AndroidComponent, routeInfo: RouteInfo, placeId: Int) {
        val activity = androidComponent.activity
        val intent = DetailRouteScreenActivity.createIntent(activity, routeInfo, placeId)
        activity.startActivity(intent)
    }
}