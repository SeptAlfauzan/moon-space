package com.septalfauzan.moonspace.favorite

import androidx.lifecycle.*
import com.septalfauzan.moonspace.core.data.Resource
import com.septalfauzan.moonspace.core.domain.model.RocketLaunchSchedule
import com.septalfauzan.moonspace.core.domain.usecase.IUpcomingLaunchUseCase

class FavoriteViewModel(private val useCase: IUpcomingLaunchUseCase) : ViewModel() {
    private val _bookmarkedUpcomingRocketLaunch: MutableLiveData<Resource<List<RocketLaunchSchedule>>> =
        MutableLiveData()
    val bookmarkedUpcomingRocketLaunch: LiveData<Resource<List<RocketLaunchSchedule>>> =
        _bookmarkedUpcomingRocketLaunch

    fun getBookmarkedLaunches() =
        useCase.getBookmarkedUpcomingLaunches().asLiveData()
            .observeForever(bookmarkedUpcomingLaunchObserver)

    private val bookmarkedUpcomingLaunchObserver: Observer<com.septalfauzan.moonspace.core.data.Resource<List<RocketLaunchSchedule>>> =
        Observer {
            _bookmarkedUpcomingRocketLaunch.postValue(it)
        }

    fun filterBookmarkedUpcomingLaunches(key: String) =
        useCase.getFilteredBookmarkedUpcomingLaunches(key).asLiveData()
            .observeForever(bookmarkedUpcomingLaunchObserver)

    fun updateBookmark(id: String) = useCase.updateBookmark(id)


    override fun onCleared() {
        super.onCleared()
        _bookmarkedUpcomingRocketLaunch.removeObserver(bookmarkedUpcomingLaunchObserver)
    }
}