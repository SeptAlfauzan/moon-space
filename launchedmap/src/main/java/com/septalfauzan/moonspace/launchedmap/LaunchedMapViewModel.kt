package com.septalfauzan.moonspace.launchedmap

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.septalfauzan.moonspace.core.domain.usecase.IUpcomingLaunchUseCase

class LaunchedMapViewModel(private val useCase: IUpcomingLaunchUseCase) : ViewModel() {
    val upComingLaunch = useCase.getUpcomingLaunches().asLiveData()
}