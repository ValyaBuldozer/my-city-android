package ru.edu.ksu.mycity.domain.network.service

import okhttp3.Callback
import okhttp3.OkHttpClient
import ru.edu.ksu.mycity.domain.network.command.PlaceFullRequestCommand
import ru.edu.ksu.mycity.domain.network.command.PlacesRequestCommand
import ru.edu.ksu.mycity.domain.network.command.RoutesRequestCommand

class NetworkServiceImpl(private val okHttpClient: OkHttpClient) : NetworkService {

    override fun getRoutes(callback: Callback) {
        RoutesRequestCommand().execute(okHttpClient, callback)
    }

    override fun getPlaces(callback: Callback) {
        PlacesRequestCommand().execute(okHttpClient, callback)
    }

    override fun getPlaceFullInfo(placeId: Int, callback: Callback) {
        PlaceFullRequestCommand(placeId).execute(okHttpClient, callback)
    }
}