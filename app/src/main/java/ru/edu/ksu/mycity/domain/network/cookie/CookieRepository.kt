package ru.edu.ksu.mycity.domain.network.cookie

import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

class CookieRepository : CookieJar {

    private val cookies = mutableMapOf<String, MutableList<Cookie>>()

    override fun saveFromResponse(url: HttpUrl, cookies: MutableList<Cookie>) {
        this.cookies[url.url().host.toString()] = cookies
    }

    override fun loadForRequest(url: HttpUrl): MutableList<Cookie> =
        cookies[url.url().host.toString()] ?: mutableListOf()

}