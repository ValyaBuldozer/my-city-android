package ru.edu.ksu.mycity.domain.network.command

import android.util.Log
import okhttp3.*
import ru.edu.ksu.mycity.domain.network.NetworkConfig
import ru.edu.ksu.mycity.domain.network.command.common.RpcCommand
import java.io.IOException

class PlaceFullRequestCommand(private val placeId : Int)  : RpcCommand {

    override fun execute(okHttpClient: OkHttpClient, callback: Callback) {
        val httpUrl = HttpUrl.Builder()
            .scheme(NetworkConfig.SCHEME.value)
            .host(NetworkConfig.HOST.value)
            .port(NetworkConfig.PORT.value.toInt())
            .addPathSegment(NetworkConfig.PLACES_PATH.value)
            .addPathSegment(placeId.toString())
            .build()

        val request = Request.Builder()
            .url(httpUrl)
            .build()

        okHttpClient.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                callback.onResponse(call, response)
            }

            override fun onFailure(call: Call, e: IOException) {
                Log.e("EXCEPTION",e.message, e.cause)
                callback.onFailure(call, e)
            }
        })
    }
}