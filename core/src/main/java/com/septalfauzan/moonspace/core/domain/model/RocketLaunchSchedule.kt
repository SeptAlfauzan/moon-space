package com.septalfauzan.moonspace.core.domain.model

data class RocketLaunchSchedule(
    val id: String,
    val imageUrl: String,
    val name: String,
    val launchedAt: String,
    val latitude: Double?,
    val longitude: Double?,
    val info: RocketLaunchInfo? = null,
    val programs: List<RocketLaunchProgram?>? = null,
    var bookmarked: Boolean,
)
