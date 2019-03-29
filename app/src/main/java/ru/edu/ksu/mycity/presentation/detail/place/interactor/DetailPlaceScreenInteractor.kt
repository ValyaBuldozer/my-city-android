package ru.edu.ksu.mycity.presentation.detail.place.interactor

import android.util.Log
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import ru.edu.ksu.mycity.domain.network.service.NetworkService
import ru.edu.ksu.mycity.entity.gson.PlaceGsonModel
import ru.edu.ksu.mycity.helpers.arch.base.BaseInteractor
import ru.edu.ksu.mycity.presentation.detail.place.contracts.DetailPlaceInteractorContract
import java.io.IOException
import java.lang.Exception

class DetailPlaceScreenInteractor(
        private val networkService: NetworkService
    ) : BaseInteractor<DetailPlaceInteractorContract.Presenter>(),
        DetailPlaceInteractorContract.Interactor {

    override fun obtainPlaceDetail(placeId: Int) {
        networkService.getPlaceFullInfo(placeId, object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runUi { listener?.obtainedPlaceDetail(null, e) }
            }

            override fun onResponse(call: Call, response: Response) {
                try {

                    val jsonString = response.body()!!.string()
                    val placeGsonModel = Gson().fromJson<PlaceGsonModel>(jsonString, PlaceGsonModel::class.java)
                    val place = placeGsonModel.getPresentation()

                    Log.wtf(Log.WARN.toString(), place.description)
                    place.description.replace("\n\n", "\n")
                    Log.wtf(Log.WARN.toString(), place.description)


                    runUi { listener?.obtainedPlaceDetail(place, null) }
                } catch (e: Exception) {
                    runUi { listener?.obtainedPlaceDetail(null, e) }
                }
            }
        })
    }

}