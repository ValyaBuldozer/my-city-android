package ru.edu.ksu.mycity.helpers.arch.contracts

interface ViperPresenter<VM : ViperViewModel> {

    var vm : VM

    fun attachView(viewModel: VM, component: AndroidComponent)

    fun detachView()

    fun isAttachView() : Boolean

    fun destroy()
}