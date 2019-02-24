package ru.edu.ksu.mycity.entity.gson

import com.google.gson.annotations.SerializedName
import ru.edu.ksu.mycity.entity.presentation.Answer

data class AnswerGsonModel(
    @SerializedName("answer_id") val id : Int,
    @SerializedName("answer_title") val title : String,
    @SerializedName("answer_is_right") val isRight : Boolean,
    @SerializedName("answer_description") val description : String
) : GsonModel<Answer> {

    override fun getPresentation(): Answer =
       Answer(id, title, isRight, description)
}