package com.septalfauzan.moonspace.screen.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.septalfauzan.moonspace.core.data.Resource
import com.septalfauzan.moonspace.core.domain.model.RocketLaunchSchedule
import com.septalfauzan.moonspace.core.domain.usecase.IUpcomingLaunchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val useCase: IUpcomingLaunchUseCase) : ViewModel() {
    fun getDetailLaunch(id: String): LiveData<Resource<RocketLaunchSchedule>> =
        useCase.getDetailLaunch(id).asLiveData()
    fun updateBookmark(id: String) = useCase.updateBookmark(id)
    fun getBookmarkStatus(id: String) = useCase.getBookmarkStatus(id).asLiveData()
}