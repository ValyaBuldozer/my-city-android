package ru.edu.ksu.mycity.entity.presentation

import android.os.Parcel
import ru.edu.ksu.mycity.helpers.arch.parcelable.ParcelableModel

data class RouteInfo(val id: Int,
                     val name: String,
                     val imagePath: String,
                     val places: List<Int>) : ParcelableModel {

    companion object {
        @JvmField
        var CREATOR = ParcelableModel.generateCreator(::RouteInfo)
    }

    private constructor(parcel: Parcel) : this(
        id = parcel.readInt(),
        name = parcel.readString(),
        imagePath = parcel.readString(),
        places = ArrayList<Int>().apply { parcel.readList(this, Int::class.java.classLoader) }
    )

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(name)
        writeString(imagePath)
        writeList(places)
    }
}