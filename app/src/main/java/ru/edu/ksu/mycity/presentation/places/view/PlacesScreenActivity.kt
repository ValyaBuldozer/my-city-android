package ru.edu.ksu.mycity.presentation.places.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import ru.edu.ksu.mycity.App
import ru.edu.ksu.mycity.R
import ru.edu.ksu.mycity.databinding.ActivityPlacesScreenBinding
import ru.edu.ksu.mycity.entity.presentation.PlaceInfo
import ru.edu.ksu.mycity.helpers.arch.base.BaseActivity
import ru.edu.ksu.mycity.presentation.places.constracts.PlacesVmContract
import ru.edu.ksu.mycity.presentation.places.interactor.PlacesScreenInteractor
import ru.edu.ksu.mycity.presentation.places.presenter.PlacesScreenPresenter
import ru.edu.ksu.mycity.presentation.places.router.PlacesScreenRouter
import ru.edu.ksu.mycity.presentation.places.view.adapter.PlacesScreenAdapter
import ru.edu.ksu.mycity.presentation.places.viewmodel.PlacesScreenViewModel

class PlacesScreenActivity : BaseActivity<PlacesVmContract.Presenter, PlacesVmContract.ViewModel>() {

    companion object {
        fun createIntent(context: Context) = Intent(context, PlacesScreenActivity::class.java)
    }

    private lateinit var binding: ActivityPlacesScreenBinding
    private lateinit var rvAdapter: PlacesScreenAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_places_screen)
        binding.setLifecycleOwner(this@PlacesScreenActivity)
        binding.viewModel = viewModel

        rvAdapter = PlacesScreenAdapter(this::onPlaceItemClick).apply {
            setItems(viewModel.places.value ?: emptyList())
        }

        val rvLayoutManager = LinearLayoutManager(this)

        binding.placesScreenRv.apply {
            adapter = rvAdapter
            layoutManager = rvLayoutManager
            setHasFixedSize(true)
        }
    }

    override fun createPresenter(): PlacesVmContract.Presenter = PlacesScreenPresenter(
        PlacesScreenInteractor(App.get().getNetworkService()),
        PlacesScreenRouter()
    )

    override fun createViewModel(): PlacesVmContract.ViewModel = PlacesScreenViewModel()

    override fun createSubscribers() {
        viewModel.places.observe(this@PlacesScreenActivity, Observer { items ->
            items?.let {
                rvAdapter.setItems(it)
            }
        })
    }

    private fun onPlaceItemClick(placeInfo: PlaceInfo) {
        presenter.onPlaceSelected(placeInfo)
    }
}
