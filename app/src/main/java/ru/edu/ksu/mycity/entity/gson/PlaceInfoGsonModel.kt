package ru.edu.ksu.mycity.entity.gson

import com.google.gson.annotations.SerializedName
import ru.edu.ksu.mycity.entity.presentation.PlaceInfo

data class PlaceInfoGsonModel(
    @SerializedName("place_id") val id : Int,
    @SerializedName("place_name") val name : String,
    @SerializedName("place_logo_path") val logoImagePath: String
) : GsonModel<PlaceInfo> {

    override fun getPresentation() = PlaceInfo(
        id, name, logoImagePath
    )
}