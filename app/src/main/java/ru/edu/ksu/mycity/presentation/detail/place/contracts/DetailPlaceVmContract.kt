package ru.edu.ksu.mycity.presentation.detail.place.contracts

import android.arch.lifecycle.MutableLiveData
import ru.edu.ksu.mycity.entity.presentation.Place
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperPresenter
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel
import ru.edu.ksu.mycity.helpers.arch.contracts.ViperViewModel.State

interface DetailPlaceVmContract {

    interface ViewModel : ViperViewModel {

        var state: MutableLiveData<State>

        var errorMessage: MutableLiveData<String?>

        var place: MutableLiveData<Place?>

        var showDescription: MutableLiveData<Boolean>
        
    }

    interface Presenter : ViperPresenter<ViewModel> {

        fun onShowDescriptionClick()

    }
}