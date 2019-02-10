package ru.edu.ksu.mycity.presentation.detail.route.interactor

import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import ru.edu.ksu.mycity.domain.network.service.NetworkService
import ru.edu.ksu.mycity.entity.gson.PlaceGsonModel
import ru.edu.ksu.mycity.helpers.arch.base.BaseInteractor
import ru.edu.ksu.mycity.presentation.detail.route.contracts.DetailRouteInteractorContract
import java.io.IOException
import java.lang.Exception

class DetailRouteScreenInteractor(
    private val networkService: NetworkService
) : BaseInteractor<DetailRouteInteractorContract.Presenter>(),
    DetailRouteInteractorContract.Interactor {

    override fun obtainRoutePlace(placeId: Int) {
        networkService.getPlaceFullInfo(placeId, object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runUi { listener?.obtainedRoutePlace(null, e) }
            }

            override fun onResponse(call: Call, response: Response) {
                try {
                    val jsonString = response.body()!!.string()
                    val placeGson = Gson().fromJson<PlaceGsonModel>(jsonString, PlaceGsonModel::class.java)
                    val place = placeGson.getPresentation()

                    runUi { listener?.obtainedRoutePlace(place, null) }
                } catch (e: Exception) {
                    runUi { listener?.obtainedRoutePlace(null, e) }
                }
            }
        })
    }
}