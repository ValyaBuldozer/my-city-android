package ru.edu.ksu.mycity.presentation.detail.place.router

import ru.edu.ksu.mycity.entity.presentation.RouteInfo
import ru.edu.ksu.mycity.helpers.arch.base.BaseRouter
import ru.edu.ksu.mycity.helpers.arch.contracts.AndroidComponent
import ru.edu.ksu.mycity.presentation.detail.place.contracts.DetailPlaceRouterContract
import ru.edu.ksu.mycity.presentation.detail.route.view.DetailRouteScreenActivity

class DetailPlaceScreenRouter : BaseRouter<DetailPlaceRouterContract.Presenter>(),
    DetailPlaceRouterContract.Router {

    override fun backToPlacesList(androidComponent: AndroidComponent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showRoutePlace(androidComponent: AndroidComponent, routeInfo: RouteInfo, placeId: Int) {
        val activity = androidComponent.activity
        val intent = DetailRouteScreenActivity.createIntent(activity, routeInfo, placeId)
        activity.startActivity(intent)
    }
}