package ru.edu.ksu.mycity.presentation.home.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import ru.edu.ksu.mycity.R
import ru.edu.ksu.mycity.databinding.ActivityHomeBinding
import ru.edu.ksu.mycity.presentation.places.view.PlacesScreenActivity
import ru.edu.ksu.mycity.presentation.routes.view.RoutesScreenActivity

class HomeActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context): Intent =
                Intent(context, HomeActivity::class.java)
    }

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.apply {
            homeMenuElementRoutes.root.setOnClickListener {
                val intent = RoutesScreenActivity.createIntent(this@HomeActivity)
                this@HomeActivity.startActivity(intent)
            }

            homeMenuElementPlaces.root.setOnClickListener {
                val intent = PlacesScreenActivity.createIntent(this@HomeActivity)
                this@HomeActivity.startActivity(intent)
            }

            homeMenuElementNearby.root.setOnClickListener {
                Toast
                    .makeText(applicationContext, "Ещё не реализовано...", Toast.LENGTH_SHORT)
                    .show()
            }

            homeMenuAppbar.appbarMenuBtn.setOnClickListener {
                Toast
                    .makeText(applicationContext, "Ещё не реализовано...", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        return
    }
}
