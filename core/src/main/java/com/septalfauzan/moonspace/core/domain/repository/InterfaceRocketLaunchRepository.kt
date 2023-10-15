package com.septalfauzan.moonspace.core.domain.repository

import com.septalfauzan.moonspace.core.data.Resource
import com.septalfauzan.moonspace.core.domain.model.RocketLaunchSchedule
import kotlinx.coroutines.flow.Flow

interface InterfaceRocketLaunchRepository {
    fun getAllUpcomingLaunch(): Flow<Resource<List<RocketLaunchSchedule>>>
    fun getAllBookmarkedUpcomingLaunch(): Flow<Resource<List<RocketLaunchSchedule>>>
    fun getFilteredUpcomingLaunch(key: String): Flow<Resource<List<RocketLaunchSchedule>>>
    fun getFilteredBookmarkedUpcomingLaunch(key: String): Flow<Resource<List<RocketLaunchSchedule>>>
    fun getDetailLaunch(id: String): Flow<Resource<RocketLaunchSchedule>>
    fun getBookmarkStatus(id: String): Flow<Boolean>
    fun updateBookmark(id: String)
}