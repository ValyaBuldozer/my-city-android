package ru.edu.ksu.mycity.entity.gson

import com.google.gson.annotations.SerializedName
import ru.edu.ksu.mycity.entity.presentation.Answer

data class AnswerGsonModel(
    @SerializedName("id") val id : Int,
    @SerializedName("title") val title : String,
    @SerializedName("is_right") val isRight : Boolean,
    @SerializedName("description") val description : String
) : GsonModel<Answer> {

    override fun getPresentation(): Answer =
       Answer(id, title, isRight, description)
}