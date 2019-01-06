package ru.edu.ksu.mycity.helpers.arch.contracts

interface ViperRouter<L : ViperRouter.Listener> {
    interface Listener

    var listener: Listener
}