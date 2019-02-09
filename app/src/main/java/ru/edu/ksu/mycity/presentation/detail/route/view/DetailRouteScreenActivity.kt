package ru.edu.ksu.mycity.presentation.detail.route.view

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import ru.edu.ksu.mycity.App
import ru.edu.ksu.mycity.R
import ru.edu.ksu.mycity.databinding.ActivityDetailRouteScreenBinding
import ru.edu.ksu.mycity.entity.presentation.RouteInfo
import ru.edu.ksu.mycity.helpers.arch.base.BaseActivity
import ru.edu.ksu.mycity.presentation.detail.route.contracts.DetailRouteVmContract
import ru.edu.ksu.mycity.presentation.detail.route.interactor.DetailRouteScreenInteractor
import ru.edu.ksu.mycity.presentation.detail.route.presenter.DetailRouteScreenPresenter
import ru.edu.ksu.mycity.presentation.detail.route.router.DetailRoutesScreenRouter
import ru.edu.ksu.mycity.presentation.detail.route.viewmodel.DetailRouteScreenViewModel

class DetailRouteScreenActivity : BaseActivity<DetailRouteVmContract.Presenter, DetailRouteVmContract.ViewModel>() {

    companion object {
        const val PLACE_ID = "PLACE_ID"
        const val ROUTE = "ROUTE"

        fun createIntent(context: Context, route: RouteInfo, placeId: Int) =
                Intent(context, DetailRouteScreenActivity::class.java).apply {
                    putExtra(PLACE_ID, placeId)
                    putExtra(ROUTE, route)
                }

        fun createIntent(context: Context, route: RouteInfo) =
                Intent(context, DetailRouteScreenActivity::class.java).apply {
                    putExtra(ROUTE, route)
                }
    }

    private lateinit var routeInfo : RouteInfo
    private var initPlaceId : Int = 0

    lateinit var binding : ActivityDetailRouteScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        routeInfo = intent.extras.getParcelable(ROUTE)
        initPlaceId = intent.extras.getInt(PLACE_ID, routeInfo.places.first())

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_route_screen)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel

        binding.detailRouteScreenShowButton.setOnClickListener(this::showDescriptionHandler)
        binding.detailRouteNextBtn.setOnClickListener(this::nextPlaceHandler)
        binding.detailRoutePrevBtn.setOnClickListener(this::prevPlaceHandler)
    }

    private fun showDescriptionHandler(view: View) {
        presenter.onShowDescriptionClick()
    }

    private fun nextPlaceHandler(view: View) {
        presenter.nextPlaceHandler()
    }

    private fun prevPlaceHandler(view: View) {
        presenter.prevPlaceHandler()
    }

    override fun createPresenter(): DetailRouteVmContract.Presenter =
        DetailRouteScreenPresenter(
            DetailRouteScreenInteractor(App.get().getNetworkService()),
            DetailRoutesScreenRouter(),
            initPlaceId,
            routeInfo
        )

    override fun createViewModel(): DetailRouteVmContract.ViewModel =
        DetailRouteScreenViewModel(
            initPlaceId,
            routeInfo.places
        )

    override fun createSubscribers() { }
}
