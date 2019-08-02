package ru.edu.ksu.mycity.entity.gson

import com.google.gson.annotations.SerializedName
import ru.edu.ksu.mycity.entity.presentation.RouteInfo

data class RouteInfoGsonModel (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("logo_path") val imagePath: String,
    @SerializedName("places") val places: List<PlaceInfoGsonModel>
) : GsonModel<RouteInfo> {

    override fun getPresentation() = RouteInfo(
        id, name, imagePath, places.map { it.getPresentation().id }
    )
}