package com.septalfauzan.moonspace.core.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.septalfauzan.moonspace.core.data.local.entity.BookmarkLaunchEntity
import com.septalfauzan.moonspace.core.data.local.entity.UpcomingLaunchEntity

@Database(entities = [UpcomingLaunchEntity::class, BookmarkLaunchEntity::class], version = 1, exportSchema = false)
abstract class MoonSpaceDatabase: RoomDatabase() {
    abstract fun upcomingLaunchDao(): UpcomingLaunchDAO
    abstract fun bookmarkLaunchDao(): BookmarkLaunchDAO
}