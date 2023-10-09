package com.septalfauzan.moonspace.core.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.septalfauzan.moonspace.core.data.local.entity.UpcomingLaunchEntity
import com.septalfauzan.moonspace.core.data.local.entity.UpcomingLaunchWithBookmarkStatus
import kotlinx.coroutines.flow.Flow

@Dao
interface UpcomingLaunchDAO {
    @Query("SELECT * FROM upcoming_launch")
    fun getALl(): Flow<List<UpcomingLaunchWithBookmarkStatus>>

    @Query("SELECT * FROM upcoming_launch INNER JOIN bookmark on upcoming_launch.id = bookmark.launch_id WHERE bookmarked_at IS NOT NULL")
    fun getALlBookmarked(): Flow<List<UpcomingLaunchWithBookmarkStatus>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(upcomingLaunches: List<UpcomingLaunchEntity>)

    @Update
    fun updateBookmark(upcomingLaunchEntity: UpcomingLaunchEntity)
}