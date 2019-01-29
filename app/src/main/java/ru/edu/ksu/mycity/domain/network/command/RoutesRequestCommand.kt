package ru.edu.ksu.mycity.domain.network.command

import android.util.Log
import okhttp3.*
import ru.edu.ksu.mycity.domain.network.NetworkConfig
import ru.edu.ksu.mycity.domain.network.command.common.RpcCommand
import java.io.IOException

class RoutesRequestCommand() : RpcCommand {
    override fun execute(okHttpClient: OkHttpClient, callback: Callback) {
//        val httpUrl = HttpUrl.Builder()
//            .scheme(NetworkConfig.SCHEME.value)
//            .host(NetworkConfig.HOST.value)
//            .port(5000)
//            .addPathSegment(NetworkConfig.ROUTES_PATH.value)
//            .build()

        val httpUrl = HttpUrl.parse("http://192.168.0.2:5000/routes")

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