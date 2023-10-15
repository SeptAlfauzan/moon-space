package com.septalfauzan.moonspace.core.helper

import com.septalfauzan.moonspace.core.data.local.entity.UpcomingLaunchEntity
import com.septalfauzan.moonspace.core.data.local.entity.UpcomingLaunchWithBookmarkStatus
import com.septalfauzan.moonspace.core.data.remote.response.ProgramItem
import com.septalfauzan.moonspace.core.data.remote.response.Rocket
import com.septalfauzan.moonspace.core.data.remote.response.RocketLaunchItem
import com.septalfauzan.moonspace.core.domain.model.RocketLaunchInfo
import com.septalfauzan.moonspace.core.domain.model.RocketLaunchProgram
import com.septalfauzan.moonspace.core.domain.model.RocketLaunchSchedule

object DataMapper {
    fun RocketLaunchItem.toUpcomingLaunchEntity(): UpcomingLaunchEntity = UpcomingLaunchEntity(id = this.id ?: "-", image = this.image ?: "",  windowStart = this.windowStart ?: "", name = this.name ?: "-", latitude = this.pad?.latitude?.toDoubleOrNull(), longitude = this.pad?.longitude?.toDoubleOrNull())

    fun UpcomingLaunchWithBookmarkStatus.toRocketLaunchSchedule(): RocketLaunchSchedule = RocketLaunchSchedule(imageUrl = this.upcomingLaunch.image, id = this.upcomingLaunch.id, launchedAt = this.upcomingLaunch.windowStart, bookmarked = this.bookmark?.bookmarkedAt?.isNotEmpty() ?: false, name = this.upcomingLaunch.name, latitude = this.upcomingLaunch.latitude, longitude = this.upcomingLaunch.longitude)

    private fun Rocket.toRocketInfo() : RocketLaunchInfo? = this.configuration?.let { data ->
        RocketLaunchInfo(spaceShipName = data.fullName ?: "-", maidenFlight = data.maidenFlight ?: "-", cost = data.launchCost ?: "-", desc = data.description ?: "-")
    }

    fun ProgramItem.toRocketLaunchProgram(): RocketLaunchProgram = this.let{
        RocketLaunchProgram(it.name ?: "-", it.description ?: "-")
    }

    private fun List<ProgramItem?>?.toRocketLaunchPrograms(): List<RocketLaunchProgram?>? = this?.map { it?.toRocketLaunchProgram() }

    fun RocketLaunchItem.toCompleteRocketLaunchSchedule(): RocketLaunchSchedule = RocketLaunchSchedule(imageUrl = this.image ?: "-", id = this.id ?: "-", launchedAt = this.windowStart ?: "-", bookmarked = true, name = this.name ?: "-", info = this.rocket?.toRocketInfo(), programs = this.rocket?.configuration?.program.toRocketLaunchPrograms(), latitude = this.pad?.latitude?.toDoubleOrNull(), longitude = this.pad?.longitude?.toDoubleOrNull())

    fun List<UpcomingLaunchWithBookmarkStatus>.toRocketLaunchSchedules() : List<RocketLaunchSchedule> = this.map { it.toRocketLaunchSchedule() }
}