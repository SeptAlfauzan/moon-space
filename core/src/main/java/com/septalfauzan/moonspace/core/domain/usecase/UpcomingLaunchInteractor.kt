package com.septalfauzan.moonspace.core.domain.usecase

import com.septalfauzan.moonspace.core.domain.model.RocketLaunchSchedule
import com.septalfauzan.moonspace.core.domain.repository.IRocketLaunchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpcomingLaunchInteractor @Inject constructor(private val repository: IRocketLaunchRepository) : IUpcomingLaunchUseCase{
    override fun getUpcomingLaunches(): Flow<com.septalfauzan.moonspace.core.data.Resource<List<RocketLaunchSchedule>>> = repository.getAllUpcomingLaunch()
    override fun getFilteredUpcomingLaunches(key: String): Flow<com.septalfauzan.moonspace.core.data.Resource<List<RocketLaunchSchedule>>> = repository.getFilteredUpcomingLaunch(key)
    override fun getBookmarkedUpcomingLaunches(): Flow<com.septalfauzan.moonspace.core.data.Resource<List<RocketLaunchSchedule>>> = repository.getAllBookmarkedUpcomingLaunch()
    override fun getFilteredBookmarkedUpcomingLaunches(key: String): Flow<com.septalfauzan.moonspace.core.data.Resource<List<RocketLaunchSchedule>>> = repository.getFilteredBookmarkedUpcomingLaunch(key)
    override fun getDetailLaunch(id: String): Flow<com.septalfauzan.moonspace.core.data.Resource<RocketLaunchSchedule>> = repository.getDetailLaunch(id)
    override fun getBookmarkStatus(id: String): Flow<Boolean> = repository.getBookmarkStatus(id)
    override fun updateBookmark(id: String) = repository.updateBookmark(id)
}