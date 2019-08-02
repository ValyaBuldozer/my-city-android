package ru.edu.ksu.mycity.entity.gson

import com.google.gson.annotations.SerializedName
import ru.edu.ksu.mycity.entity.presentation.Place

data class PlaceGsonModel(
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("logo_path") val logoImagePath: String,
    @SerializedName("image_path") val backgroundImagePath: String,
    @SerializedName("description") val description: String,
    @SerializedName("question_title") val questionTitle: String,
    @SerializedName("address") val address: String,
    @SerializedName("routes") val routes: List<RouteInfoGsonModel>,
    @SerializedName("answers") val answers: List<AnswerGsonModel>
) : GsonModel<Place> {

    override fun getPresentation() = Place(
        id,
        name,
        logoImagePath,
        backgroundImagePath,
        description,
        questionTitle,
        address,
        routes.map { it.getPresentation() },
        answers.map { it.getPresentation() }
    )
}