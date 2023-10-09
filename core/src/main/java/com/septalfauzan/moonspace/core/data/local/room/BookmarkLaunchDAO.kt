package com.septalfauzan.moonspace.core.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.septalfauzan.moonspace.core.data.local.entity.BookmarkLaunchEntity
import com.septalfauzan.moonspace.core.data.local.entity.UpcomingLaunchEntity
import com.septalfauzan.moonspace.core.data.local.entity.UpcomingLaunchWithBookmarkStatus
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkLaunchDAO {
    @Query("SELECT * FROM bookmark where launch_id=:id")
    fun getBookmark(id: String): Flow<BookmarkLaunchEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookmark(bookmarkLaunchEntity: BookmarkLaunchEntity)

    @Delete
    fun deleteBookmark(bookmarkLaunchEntity: BookmarkLaunchEntity)
}