package com.septalfauzan.moonspace.favorite

import androidx.lifecycle.*
import com.septalfauzan.moonspace.core.data.Resource
import com.septalfauzan.moonspace.core.domain.model.RocketLaunchSchedule
import com.septalfauzan.moonspace.core.domain.usecase.IUpcomingLaunchUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FavoriteViewModel(private val useCase: IUpcomingLaunchUseCase) : ViewModel() {
    private val _bookmarkedUpcomingRocketLaunch: MutableLiveData<Resource<List<RocketLaunchSchedule>>> =
        MutableLiveData()
    val bookmarkedUpcomingRocketLaunch: LiveData<Resource<List<RocketLaunchSchedule>>> =
        _bookmarkedUpcomingRocketLaunch

    fun getBookmarkedLaunches(){
        viewModelScope.launch{
            useCase.getBookmarkedUpcomingLaunches().catch { err ->
                _bookmarkedUpcomingRocketLaunch.postValue(Resource.Error(err.message ?: "Error fetching bookmarked "))
            }.collect{data ->
                _bookmarkedUpcomingRocketLaunch.postValue(data)
            }
        }
    }

    private val bookmarkedUpcomingLaunchObserver: Observer<com.septalfauzan.moonspace.core.data.Resource<List<RocketLaunchSchedule>>> =
        Observer {
            _bookmarkedUpcomingRocketLaunch.postValue(it)
        }

    fun filterBookmarkedUpcomingLaunches(key: String) =
        useCase.getFilteredBookmarkedUpcomingLaunches(key).asLiveData()
            .observeForever(bookmarkedUpcomingLaunchObserver)

    fun updateBookmark(id: String) = useCase.updateBookmark(id)
}