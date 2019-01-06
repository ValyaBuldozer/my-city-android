package ru.edu.ksu.mycity.helpers.arch.contracts

interface ViperInteractor<L : ViperInteractor.Listener> {
    interface Listener

    var listener: L?
}