package ru.edu.ksu.mycity.presentation.splashscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.edu.ksu.mycity.App
import ru.edu.ksu.mycity.R
import ru.edu.ksu.mycity.presentation.home.view.HomeActivity
import java.util.*
import kotlin.concurrent.schedule

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Timer("splash_timer").schedule(1000) {
            App.instance.handlerUi.post {
                val intent = HomeActivity.createIntent(this@SplashScreenActivity)
                this@SplashScreenActivity.startActivity(intent)
            }
        }
    }
}
