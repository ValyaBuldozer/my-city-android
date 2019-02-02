package ru.edu.ksu.mycity.entity.presentation

import android.os.Parcel
import ru.edu.ksu.mycity.helpers.arch.parcelable.ParcelableModel

data class PlaceInfo(
    val id : Int,
    val name : String,
    val logoImagePath : String) : ParcelableModel {

    companion object {
        @JvmField
        var CREATOR = ParcelableModel.generateCreator(::PlaceInfo)
    }

    private constructor(parcel: Parcel) : this(
        id = parcel.readInt(),
        name = parcel.readString(),
        logoImagePath = parcel.readString()
    )

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(name)
        writeString(logoImagePath)
    }
}