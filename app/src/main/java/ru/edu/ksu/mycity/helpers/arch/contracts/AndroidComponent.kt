package ru.edu.ksu.mycity.helpers.arch.contracts

import android.app.Activity
import android.support.v4.app.FragmentManager

interface AndroidComponent {
    val activty: Activity
    val fragmentManager: FragmentManager
}