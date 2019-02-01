package ru.edu.ksu.mycity.entity.gson

import ru.edu.ksu.mycity.helpers.arch.parcelable.ParcelableModel

interface GsonModel<MODEL_TYPE : ParcelableModel> {
    fun getPresentation() : MODEL_TYPE
}