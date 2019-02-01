package ru.edu.ksu.mycity.domain.network

enum class NetworkConfig(val value: String) {

    SCHEME("http"),
    HOST("10.0.2.2"),
    PORT("5000"),
    ROUTES_PATH("routes"),
    PLACES_PATH("places"),

}