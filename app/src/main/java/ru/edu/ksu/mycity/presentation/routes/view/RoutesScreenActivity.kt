package ru.edu.ksu.mycity.presentation.routes.view

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import ru.edu.ksu.mycity.App
import ru.edu.ksu.mycity.R
import ru.edu.ksu.mycity.databinding.ActivityRoutesScreenBinding
import ru.edu.ksu.mycity.entity.presentation.Route
import ru.edu.ksu.mycity.helpers.arch.base.BaseActivity
import ru.edu.ksu.mycity.presentation.routes.contracts.RoutesVmContract
import ru.edu.ksu.mycity.presentation.routes.interactor.RoutesScreenInteractor
import ru.edu.ksu.mycity.presentation.routes.presenter.RoutesScreenPresenter
import ru.edu.ksu.mycity.presentation.routes.router.RoutesScreenRouter
import ru.edu.ksu.mycity.presentation.routes.view.adapter.RoutesScreenAdapter
import ru.edu.ksu.mycity.presentation.routes.viewmodel.RoutesScreenViewModel

class RoutesScreenActivity : BaseActivity<RoutesVmContract.Presenter, RoutesVmContract.ViewModel>() {

    companion object {

        fun createIntent(context: Context): Intent =
            Intent(context, RoutesScreenActivity::class.java).apply {
                // params...
            }

    }

    private lateinit var binding: ActivityRoutesScreenBinding
    private lateinit var routesAdapter: RoutesScreenAdapter

    private fun onRouteItemClick(route: Route) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_routes_screen)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_routes_screen)
        binding.setLifecycleOwner(this@RoutesScreenActivity)
        binding.viewModel = viewModel

        routesAdapter = RoutesScreenAdapter(this::onRouteItemClick).apply {
            setItems(viewModel.routes.value ?: emptyList())
        }

        val linearLayoutManager = LinearLayoutManager(this)

        binding.routesScreenRv.apply {
            adapter = routesAdapter
            layoutManager = linearLayoutManager
            setHasFixedSize(true)
        }
    }

    override fun createPresenter(): RoutesVmContract.Presenter =
        RoutesScreenPresenter(
            RoutesScreenInteractor(App.get().getNetworkService()),
            RoutesScreenRouter()
        )

    override fun createSubscribers() {
        viewModel.routes.observe(this@RoutesScreenActivity, Observer { items ->
            items?.let { routesAdapter.setItems(it) }
        })
    }

    override fun createViewModel(): RoutesVmContract.ViewModel =
        ViewModelProviders.of(this).get(RoutesScreenViewModel::class.java)
}
