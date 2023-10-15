package com.septalfauzan.moonspace.launchedmap

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.septalfauzan.moonspace.core.domain.usecase.InterfaceUpcomingLaunchUseCase

class LaunchedMapViewModel(private val useCase: InterfaceUpcomingLaunchUseCase) : ViewModel() {
    val upComingLaunch = useCase.getUpcomingLaunches().asLiveData()
}