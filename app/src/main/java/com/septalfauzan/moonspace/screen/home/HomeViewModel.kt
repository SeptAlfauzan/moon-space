package com.septalfauzan.moonspace.screen.home

import android.util.Log
import androidx.lifecycle.*
import com.septalfauzan.moonspace.core.data.Resource
import com.septalfauzan.moonspace.core.domain.model.RocketLaunchSchedule
import com.septalfauzan.moonspace.core.domain.usecase.InterfaceUpcomingLaunchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: InterfaceUpcomingLaunchUseCase) :
    ViewModel() {
    private val _upcomingRocketLaunch: MutableLiveData<com.septalfauzan.moonspace.core.data.Resource<List<RocketLaunchSchedule>>> =
        MutableLiveData()
    val upcomingRocketLaunch: LiveData<com.septalfauzan.moonspace.core.data.Resource<List<RocketLaunchSchedule>>> =
        _upcomingRocketLaunch

    fun getUpcomingLaunches() {
        viewModelScope.launch{
            useCase.getUpcomingLaunches().catch { err ->
                Log.d("ERROR", "error: $err")
                _upcomingRocketLaunch.postValue(Resource.Error(err.message ?: "error fetching data"))
            }.collect { data ->
                _upcomingRocketLaunch.postValue(data)
            }
        }
    }

    fun filterUpcomingLaunches(key: String){
        viewModelScope.launch {
            useCase.getFilteredUpcomingLaunches(key).catch { err ->
                _upcomingRocketLaunch.postValue(
                    Resource.Error(
                        err.message ?: "error when filtering data"
                    )
                )
            }.collect { data ->
                _upcomingRocketLaunch.postValue(data)
            }
        }
    }

    fun updateBookmark(id: String) = useCase.updateBookmark(id)
}