package ru.edu.ksu.mycity.entity.presentation

import android.os.Parcel
import ru.edu.ksu.mycity.helpers.arch.parcelable.ParcelableModel

data class Place(
    val id : Int,
    val name : String,
    val logoImagePath : String,
    val backgroundImagePath : String,
    val description : String,
    val questionTitle : String) : ParcelableModel {

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
        questionTitle = parcel.readString()
    )

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(name)
        writeString(logoImagePath)
        writeString(backgroundImagePath)
        writeString(description)
        writeString(questionTitle)
    }
}