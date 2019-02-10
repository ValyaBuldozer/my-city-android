package ru.edu.ksu.mycity.helpers.arch.contracts

import java.util.*

interface ViperViewModel {

    enum class State {
        INITIAL, LOADING, DATA,ERROR
    }

    val uuid: UUID
}