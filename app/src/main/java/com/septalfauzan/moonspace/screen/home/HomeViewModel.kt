package com.septalfauzan.moonspace.screen.home

import androidx.lifecycle.*
import com.septalfauzan.moonspace.core.domain.model.RocketLaunchSchedule
import com.septalfauzan.moonspace.core.domain.usecase.IUpcomingLaunchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: IUpcomingLaunchUseCase) :
    ViewModel() {
    private val _upcomingRocketLaunch: MutableLiveData<com.septalfauzan.moonspace.core.data.Resource<List<RocketLaunchSchedule>>> =
        MutableLiveData()
    val upcomingRocketLaunch: LiveData<com.septalfauzan.moonspace.core.data.Resource<List<RocketLaunchSchedule>>> = _upcomingRocketLaunch

    fun getUpcomingLaunches() = useCase.getUpcomingLaunches().asLiveData().observeForever(upcomingLaunchObserver)
    fun filterUpcomingLaunches(key: String) = useCase.getFilteredUpcomingLaunches(key).asLiveData().observeForever(upcomingLaunchObserver)
    fun updateBookmark(id: String) = useCase.updateBookmark(id)

    private val upcomingLaunchObserver: Observer<com.septalfauzan.moonspace.core.data.Resource<List<RocketLaunchSchedule>>> = Observer {
        _upcomingRocketLaunch.postValue(it)
    }
    override fun onCleared() {
        super.onCleared()
        _upcomingRocketLaunch.removeObserver(upcomingLaunchObserver)
    }

}