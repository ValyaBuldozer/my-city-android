package ru.edu.ksu.mycity.entity.gson

import com.google.gson.annotations.SerializedName
import ru.edu.ksu.mycity.entity.presentation.Route

data class RouteGsonModel (
    @SerializedName("route_id") val id: Int,
    @SerializedName("route_name") val name: String,
    @SerializedName("route_image_path") val imagePath: String,
    @SerializedName("route_description") val description: String
) : GsonModel<Route> {

    override fun getPresentation() = Route(
        id, name, imagePath, description
    )
}