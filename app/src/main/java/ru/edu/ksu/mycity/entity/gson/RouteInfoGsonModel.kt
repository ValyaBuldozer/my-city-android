package ru.edu.ksu.mycity.entity.gson

import com.google.gson.annotations.SerializedName
import ru.edu.ksu.mycity.entity.presentation.RouteInfo

data class RouteInfoGsonModel (
    @SerializedName("route_id") val id: Int,
    @SerializedName("route_name") val name: String,
    @SerializedName("route_logo_path") val imagePath: String
) : GsonModel<RouteInfo> {

    override fun getPresentation() = RouteInfo(
        id, name, imagePath
    )
}