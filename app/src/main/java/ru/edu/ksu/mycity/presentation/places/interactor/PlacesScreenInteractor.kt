package ru.edu.ksu.mycity.presentation.places.interactor

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import ru.edu.ksu.mycity.domain.network.service.NetworkService
import ru.edu.ksu.mycity.entity.gson.PlaceInfoGsonModel
import ru.edu.ksu.mycity.helpers.arch.base.BaseInteractor
import ru.edu.ksu.mycity.presentation.places.constracts.PlacesInteractorContract
import java.io.IOException
import java.lang.Exception

class PlacesScreenInteractor(
        private val networkService: NetworkService
    ) : PlacesInteractorContract.Interactor, BaseInteractor<PlacesInteractorContract.Presenter>() {

    override fun obtainPlaces() {
        networkService.getPlaces(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runUi {
                    listener?.obtainedPlaces(emptyList(), e)
                }
            }

            override fun onResponse(call: Call, response: Response) {
                try {

                    val jsonString = response.body()!!.string()
                    val type = object : TypeToken<List<PlaceInfoGsonModel>>() {}.type
                    val placesJson = Gson().fromJson<List<PlaceInfoGsonModel>>(jsonString, type)
                    val places = placesJson.map { it.getPresentation() }

                    runUi { listener?.obtainedPlaces(places, null) }
                } catch (e: Exception) {
                    runUi { listener?.obtainedPlaces(emptyList(), e) }
                }
            }
        })
    }
}