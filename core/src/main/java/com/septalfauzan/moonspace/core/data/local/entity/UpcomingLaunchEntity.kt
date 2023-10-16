package com.septalfauzan.moonspace.core.data.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.*
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "upcoming_launch")
data class UpcomingLaunchEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "window_start")
    val windowStart: String,

    @ColumnInfo(name = "image")
    val image: String,

    @ColumnInfo(name = "latitude")
    val latitude: Double?,

    @ColumnInfo(name = "longitude")
    val longitude: Double?

) : Parcelable

data class UpcomingLaunchWithBookmarkStatus(
    @Embedded val upcomingLaunch: UpcomingLaunchEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "launch_id"
    )
    val bookmark: BookmarkLaunchEntity?
)
