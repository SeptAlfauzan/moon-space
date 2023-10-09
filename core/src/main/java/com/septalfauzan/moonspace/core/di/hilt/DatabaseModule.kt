package com.septalfauzan.moonspace.core.di.hilt

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.septalfauzan.moonspace.core.data.local.room.BookmarkLaunchDAO
import com.septalfauzan.moonspace.core.data.local.room.MoonSpaceDatabase
import com.septalfauzan.moonspace.core.data.local.room.UpcomingLaunchDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MoonSpaceDatabase = Room.databaseBuilder(
        context,
        MoonSpaceDatabase::class.java,
        "moonspace.db",
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun upcomingLaunchDao(database: MoonSpaceDatabase): UpcomingLaunchDAO = database.upcomingLaunchDao()

    @Provides
    fun bookmarkLaunchDao(database: MoonSpaceDatabase): BookmarkLaunchDAO = database.bookmarkLaunchDao()
}