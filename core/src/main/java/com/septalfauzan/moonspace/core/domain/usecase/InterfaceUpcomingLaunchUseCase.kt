package com.septalfauzan.moonspace.core.domain.usecase

import com.septalfauzan.moonspace.core.domain.model.RocketLaunchSchedule
import kotlinx.coroutines.flow.Flow

interface InterfaceUpcomingLaunchUseCase {
    fun getUpcomingLaunches(): Flow<com.septalfauzan.moonspace.core.data.Resource<List<RocketLaunchSchedule>>>
    fun getFilteredUpcomingLaunches(key: String): Flow<com.septalfauzan.moonspace.core.data.Resource<List<RocketLaunchSchedule>>>
    fun getBookmarkedUpcomingLaunches(): Flow<com.septalfauzan.moonspace.core.data.Resource<List<RocketLaunchSchedule>>>
    fun getFilteredBookmarkedUpcomingLaunches(key: String): Flow<com.septalfauzan.moonspace.core.data.Resource<List<RocketLaunchSchedule>>>
    fun getDetailLaunch(id: String): Flow<com.septalfauzan.moonspace.core.data.Resource<RocketLaunchSchedule>>
    fun getBookmarkStatus(id: String): Flow<Boolean>
    fun updateBookmark(id: String)
}