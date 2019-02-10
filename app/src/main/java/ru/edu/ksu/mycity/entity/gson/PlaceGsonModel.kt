package ru.edu.ksu.mycity.entity.gson

import com.google.gson.annotations.SerializedName
import ru.edu.ksu.mycity.entity.presentation.Place

data class PlaceGsonModel(
    @SerializedName("place_id") val id : Int,
    @SerializedName("place_name") val name : String,
    @SerializedName("place_logo_path") val logoImagePath: String,
    @SerializedName("place_image_path") val backgroundImagePath: String,
    @SerializedName("place_description") val description: String,
    @SerializedName("place_question_title") val questionTitle: String,
    @SerializedName("place_routes") val routes: List<RouteInfoGsonModel>
) : GsonModel<Place> {

    override fun getPresentation() = Place(
        id,
        name,
        logoImagePath,
        backgroundImagePath,
        description,
        questionTitle,
        routes.map { it.getPresentation() }
    )
}