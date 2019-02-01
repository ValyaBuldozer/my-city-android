package ru.edu.ksu.mycity.helpers.arch.base

import ru.edu.ksu.mycity.helpers.arch.contracts.AndroidComponent
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperPresenter
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel

abstract class BasePresenter<VM : ViperViewModel> : ViperPresenter<VM> {

    override lateinit var vm: VM
    protected var androidComponent: AndroidComponent? = null

    override fun attachView(viewModel: VM, component: AndroidComponent) {
        vm = viewModel
        androidComponent = component
    }

    override fun detachView() {
        androidComponent = null
    }

    override fun isAttachedView() = androidComponent != null

    override fun destroy() {

    }
}