package ru.edu.ksu.mycity.entity.presentation

import android.os.Parcel
import ru.edu.ksu.mycity.helpers.arch.parcelable.ParcelableModel

data class Place(
    val id : Int,
    val name : String,
    val logoImagePath : String,
    val backgroundImagePath : String,
    val description : String,
    val questionTitle : String,
    val address: String,
    val routes: List<RouteInfo>,
    val answers: List<Answer>) : ParcelableModel {

    companion object {
        @JvmField
        var CREATOR = ParcelableModel.generateCreator(::Place)
    }

    private constructor(parcel: Parcel) : this(
        id = parcel.readInt(),
        name = parcel.readString(),
        logoImagePath = parcel.readString(),
        backgroundImagePath = parcel.readString(),
        description = parcel.readString(),
        questionTitle = parcel.readString(),
        address = parcel.readString(),
        routes = ArrayList<RouteInfo>().apply { parcel.readList(this, RouteInfo::class.java.classLoader) },
        answers = ArrayList<Answer>().apply { parcel.readList(this, Answer::class.java.classLoader) }
    )

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(name)
        writeString(logoImagePath)
        writeString(backgroundImagePath)
        writeString(description)
        writeString(questionTitle)
        writeString(address)
        writeList(routes)
        writeList(answers)
    }
}