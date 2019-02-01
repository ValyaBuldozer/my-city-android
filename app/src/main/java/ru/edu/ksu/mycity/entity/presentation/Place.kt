package ru.edu.ksu.mycity.entity.presentation

import android.os.Parcel
import ru.edu.ksu.mycity.helpers.arch.parcelable.ParcelableModel

data class Place(
    val id : Int,
    val name : String,
    val description : String,
    val logoImagePath : String,
    val backgroundImagePath : String ) : ParcelableModel {

    companion object {
        @JvmField
        var CREATOR = ParcelableModel.generateCreator(::Place)
    }

    private constructor(parcel: Parcel) : this(
        id = parcel.readInt(),
        name = parcel.readString(),
        description = parcel.readString(),
        logoImagePath = parcel.readString(),
        backgroundImagePath = parcel.readString()
    )

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(name)
        writeString(description)
        writeString(logoImagePath)
        writeString(backgroundImagePath)
    }
}