package ru.edu.ksu.mycity.domain.network.command.common

import okhttp3.Callback
import okhttp3.OkHttpClient

interface RpcCommand {
    fun execute(okHttpClient: OkHttpClient, callback: Callback)
}