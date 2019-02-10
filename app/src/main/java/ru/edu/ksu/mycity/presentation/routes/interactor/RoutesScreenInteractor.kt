package ru.edu.ksu.mycity.presentation.routes.interactor

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Call
import ru.edu.ksu.mycity.domain.network.service.NetworkService
import ru.edu.ksu.mycity.helpers.arch.base.BaseInteractor
import ru.edu.ksu.mycity.presentation.routes.contracts.RoutesInteractorContract
import okhttp3.Callback
import okhttp3.Response
import ru.edu.ksu.mycity.entity.gson.RouteInfoGsonModel
import java.io.IOException
import java.lang.Exception

class RoutesScreenInteractor(private val networkService: NetworkService) : RoutesInteractorContract.Interactor, BaseInteractor<RoutesInteractorContract.Presenter>() {

    override fun obtainRoutes() {

        networkService.getRoutes(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runUi {
                    listener?.obtainedRoutes(emptyList(), e)
                }
            }

            override fun onResponse(call: Call, response: Response) {
                runUi {
                    try {

                        val json = response.body()!!.string()
                        val type = object : TypeToken<List<RouteInfoGsonModel>>() {}.type
                        val routesGson = Gson().fromJson<List<RouteInfoGsonModel>>(json, type)
                        val routes = routesGson.map { it.getPresentation() }

                        runUi { listener?.obtainedRoutes(routes, null) }
                    } catch (e : Exception) {
                        runUi { listener?.obtainedRoutes(emptyList(), e) }
                    }
                }
            }

        })
    }
}