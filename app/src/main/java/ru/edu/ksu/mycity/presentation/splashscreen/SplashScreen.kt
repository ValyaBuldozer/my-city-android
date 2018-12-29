package ru.edu.ksu.mycity.presentation.splashscreen

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ru.edu.ksu.mycity.R

class SplashScreen : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }
}
