package ru.edu.ksu.mycity.helpers.arch.base

import ru.edu.ksu.mycity.helpers.arch.contracts.ViperRouter

abstract class BaseRouter<L : ViperRouter.Listener> : ViperRouter<L> {
    override lateinit var listener: ViperRouter.Listener

}