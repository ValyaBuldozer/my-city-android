package ru.edu.ksu.mycity.helpers.arch.base

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import ru.edu.ksu.mycity.helpers.arch.contracts.AndroidComponent
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperPresenter
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel

abstract class BaseActivity<PRESENTER: ViperPresenter<VIEW_MODEL>, VIEW_MODEL : ViperViewModel>
    : AppCompatActivity(), AndroidComponent{

    lateinit var presenter: PRESENTER
    lateinit var viewModel: VIEW_MODEL

    val activity: Activity
        get() = this@BaseActivity

    override val fragmentManager: FragmentManager
        get() = this.supportFragmentManager

    abstract fun createPresenter(): PRESENTER
    abstract fun createViewModel(): VIEW_MODEL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = createViewModel()
        presenter = createPresenter()


    }
}