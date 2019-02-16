package ru.edu.ksu.mycity.helpers.arch.base

import androidx.lifecycle.ViewModel
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel
import java.util.*

abstract class BaseViewModel(override val uuid: UUID = UUID.randomUUID()) : ViewModel(), ViperViewModel