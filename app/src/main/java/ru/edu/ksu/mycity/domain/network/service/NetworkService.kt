package ru.edu.ksu.mycity.domain.network.service

import okhttp3.Callback

interface NetworkService {

    fun getRoutes(callback: Callback)

    fun getPlaces(callback: Callback)
}