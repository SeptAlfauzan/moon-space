package com.septalfauzan.moonspace.core.data.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "bookmark")
data class BookmarkLaunchEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "launch_id")
    val launchId: String,

    @ColumnInfo(name = "bookmarked_at")
    val bookmarkedAt: String,
) : Parcelable
