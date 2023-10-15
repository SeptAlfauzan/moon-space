package com.septalfauzan.moonspace.launchedmap.helper

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.septalfauzan.moonspace.core.domain.usecase.InterfaceUpcomingLaunchUseCase
import com.septalfauzan.moonspace.launchedmap.LaunchedMapViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val usecase: InterfaceUpcomingLaunchUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(LaunchedMapViewModel::class.java) -> {
                LaunchedMapViewModel(usecase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}