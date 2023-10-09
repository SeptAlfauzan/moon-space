package com.septalfauzan.moonspace.core.data.local

import com.septalfauzan.moonspace.core.data.local.entity.BookmarkLaunchEntity
import com.septalfauzan.moonspace.core.data.local.entity.UpcomingLaunchEntity
import com.septalfauzan.moonspace.core.data.local.entity.UpcomingLaunchWithBookmarkStatus
import com.septalfauzan.moonspace.core.data.local.room.MoonSpaceDatabase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val database: MoonSpaceDatabase) {
    fun getAllUpcomingLaunch(): Flow<List<UpcomingLaunchWithBookmarkStatus>> =
        database.upcomingLaunchDao().getALl()

    suspend fun insertUpcomingLaunch(data: List<UpcomingLaunchEntity>) =
        database.upcomingLaunchDao().insert(data)

    fun getBookmark(id: String) = database.bookmarkLaunchDao().getBookmark(id)

    fun getAllBookmarkedLaunch(): Flow<List<UpcomingLaunchWithBookmarkStatus>> = database.upcomingLaunchDao().getALlBookmarked()

    suspend fun insertBookmark(data: BookmarkLaunchEntity) = database.bookmarkLaunchDao().insertBookmark(data)

    fun deleteBookmark(data: BookmarkLaunchEntity) = database.bookmarkLaunchDao().deleteBookmark(data)
}