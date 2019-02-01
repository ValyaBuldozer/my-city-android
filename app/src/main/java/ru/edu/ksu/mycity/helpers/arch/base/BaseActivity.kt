package ru.edu.ksu.mycity.helpers.arch.base

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import ru.edu.ksu.mycity.helpers.arch.contracts.AndroidComponent
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperPresenter
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel

abstract class BaseActivity<PRESENTER: ViperPresenter<VIEW_MODEL>, VIEW_MODEL : ViperViewModel>
    : AppCompatActivity(), AndroidComponent{

    lateinit var presenter: PRESENTER
    lateinit var viewModel: VIEW_MODEL

    override val activity: Activity
        get() = this@BaseActivity

    override val fragmentManager: FragmentManager
        get() = this.supportFragmentManager

    abstract fun createPresenter(): PRESENTER
    abstract fun createViewModel(): VIEW_MODEL
    abstract fun createSubscribers()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = createViewModel()
        createSubscribers()
        presenter = createPresenter()


    }

    override fun onRestart() {
        super.onRestart()
        attachView()
    }

    override fun onStart() {
        super.onStart()
        attachView()
    }

    override fun onStop() {
        with(presenter) {
            detachView()

            //TODO(PRESENTER STORAGE)
//            if (!isChangingConfigurations) destroy()
//            else PresenterStorage.instance.save(vm.id, this)
        }

        super.onStop()
    }

    override fun onDestroy() {
        if (!isChangingConfigurations) presenter.destroy()
        super.onDestroy()
    }

    private fun attachView() {
        with(presenter) {
            if (!isAttachedView()) attachView(this@BaseActivity.viewModel, this@BaseActivity)
        }
    }
}