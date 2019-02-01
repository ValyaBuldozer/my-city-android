package ru.edu.ksu.mycity.helpers.arch.base

import ru.edu.ksu.mycity.App
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperInteractor

abstract class BaseInteractor<L : ViperInteractor.Listener> : ViperInteractor<L> {

    override var listener: L? = null

    fun runUi(action: () -> Unit) {
        App.get().handlerUi.post { action() }
    }
}