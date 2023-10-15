package com.septalfauzan.moonspace.favorite

import androidx.lifecycle.*
import com.septalfauzan.moonspace.core.data.Resource
import com.septalfauzan.moonspace.core.domain.model.RocketLaunchSchedule
import com.septalfauzan.moonspace.core.domain.usecase.InterfaceUpcomingLaunchUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class FavoriteViewModel(private val useCase: InterfaceUpcomingLaunchUseCase) : ViewModel() {
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
    fun filterBookmarkedUpcomingLaunches(key: String){
        viewModelScope.launch {
            useCase.getFilteredBookmarkedUpcomingLaunches(key).catch { err ->
                _bookmarkedUpcomingRocketLaunch.postValue(
                    Resource.Error(
                        err.message ?: "error when filtering data"
                    )
                )
            }.collect { data ->
                _bookmarkedUpcomingRocketLaunch.postValue(data)
            }
        }
    }

    fun updateBookmark(id: String) = useCase.updateBookmark(id)
}