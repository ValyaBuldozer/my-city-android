package ru.edu.ksu.mycity

import android.app.Application
import okhttp3.OkHttpClient
import ru.edu.ksu.mycity.domain.network.cookie.CookieRepository
import ru.edu.ksu.mycity.domain.network.service.NetworkService
import ru.edu.ksu.mycity.domain.network.service.NetworkServiceImpl
import java.util.concurrent.TimeUnit

class App : Application() {

    companion object {

        private val CONNECTION_TIMEOUT = 300L

        private val SOCKET_TIMEOUT = 300L

        lateinit var instance: App

        fun get() = instance
    }

    private val cookieRepos = CookieRepository()

    private lateinit var okHttpClient: OkHttpClient

    override fun onCreate() {
        super.onCreate()

        instance = this

        okHttpClient = OkHttpClient.Builder()
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(SOCKET_TIMEOUT, TimeUnit.SECONDS)
            .cookieJar(cookieRepos)
            .build()
    }

    fun getNetworkService() : NetworkService =
        NetworkServiceImpl(okHttpClient)

    fun getCookieRepository() : CookieRepository =
        CookieRepository()
}