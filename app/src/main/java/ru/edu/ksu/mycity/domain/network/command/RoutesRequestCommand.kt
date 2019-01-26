package ru.edu.ksu.mycity.domain.network.command

import okhttp3.*
import ru.edu.ksu.mycity.domain.network.command.common.RpcCommand
import java.io.IOException

class RoutesRequestCommand() : RpcCommand {
    override fun execute(okHttpClient: OkHttpClient, callback: Callback) {
        val httpUrl = HttpUrl.Builder()
            .scheme("http")
            .host("192.168.0.2")
            .addPathSegment("routes")
            .build()

        val request = Request.Builder()
            .url(httpUrl)
            .build()

        okHttpClient.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                callback.onResponse(call, response)
            }

            override fun onFailure(call: Call, e: IOException) {
                callback.onFailure(call, e)
            }
        })

    }
}