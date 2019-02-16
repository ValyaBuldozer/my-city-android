package ru.edu.ksu.mycity.helpers.arch.contracts

import android.app.Activity
import androidx.fragment.app.FragmentManager

interface AndroidComponent {
    val activity: Activity
    val fragmentManager: FragmentManager
}