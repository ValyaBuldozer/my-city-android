package ru.edu.ksu.mycity.presentation.detail.route.view

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
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

        fun createIntent(context: Context, placeId: Int, route: RouteInfo) =
                Intent(context, DetailRouteScreenActivity::class.java).apply {
                    putExtra(PLACE_ID, placeId)
                    putExtra(ROUTE, route)
                }
    }

    lateinit var binding : ActivityDetailRouteScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_route_screen)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel

        binding.detailRouteScreenShowButton.setOnClickListener(this::showDescriptionHandler)
    }

    fun showDescriptionHandler(view: View) {
        presenter.onShowDescriptionClick()
    }

    override fun createPresenter(): DetailRouteVmContract.Presenter =
        DetailRouteScreenPresenter(
            DetailRouteScreenInteractor(App.get().getNetworkService()),
            DetailRoutesScreenRouter(),
            intent.extras.getInt(PLACE_ID)
        )

    override fun createViewModel(): DetailRouteVmContract.ViewModel =
        DetailRouteScreenViewModel()

    override fun createSubscribers() { }
}
