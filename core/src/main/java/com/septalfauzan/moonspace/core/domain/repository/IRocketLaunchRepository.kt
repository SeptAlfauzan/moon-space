package com.septalfauzan.moonspace.core.domain.repository

import com.septalfauzan.moonspace.core.data.Resource
import com.septalfauzan.moonspace.core.domain.model.RocketLaunchSchedule
import kotlinx.coroutines.flow.Flow

interface IRocketLaunchRepository {
    fun getAllUpcomingLaunch(): Flow<com.septalfauzan.moonspace.core.data.Resource<List<RocketLaunchSchedule>>>
    fun getAllBookmarkedUpcomingLaunch(): Flow<com.septalfauzan.moonspace.core.data.Resource<List<RocketLaunchSchedule>>>
    fun getFilteredUpcomingLaunch(key: String): Flow<com.septalfauzan.moonspace.core.data.Resource<List<RocketLaunchSchedule>>>
    fun getFilteredBookmarkedUpcomingLaunch(key: String): Flow<com.septalfauzan.moonspace.core.data.Resource<List<RocketLaunchSchedule>>>
    fun getDetailLaunch(id: String): Flow<com.septalfauzan.moonspace.core.data.Resource<RocketLaunchSchedule>>
    fun getBookmarkStatus(id: String): Flow<Boolean>
    fun updateBookmark(id: String)
}