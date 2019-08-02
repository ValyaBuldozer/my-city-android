package ru.edu.ksu.mycity.entity.gson

import com.google.gson.annotations.SerializedName
import ru.edu.ksu.mycity.entity.presentation.PlaceInfo

data class PlaceInfoGsonModel(
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("logo_path") val logoImagePath: String,
    @SerializedName("lat") val latitude: String?,
    @SerializedName("lng") val longitude: String?
) : GsonModel<PlaceInfo> {

    override fun getPresentation() = PlaceInfo(
        id, name, logoImagePath, latitude, longitude
    )
}