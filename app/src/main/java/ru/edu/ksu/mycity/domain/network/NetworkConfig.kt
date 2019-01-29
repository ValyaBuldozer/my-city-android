package ru.edu.ksu.mycity.domain.network

enum class NetworkConfig(val value: String) {

    SCHEME("http"),
    HOST("192.168.0.2:5000"),
    ROUTES_PATH("routes")

}