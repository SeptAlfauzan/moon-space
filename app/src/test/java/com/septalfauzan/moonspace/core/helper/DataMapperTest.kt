package com.septalfauzan.moonspace.core.helper

import com.septalfauzan.moonspace.core.data.local.entity.UpcomingLaunchEntity
import com.septalfauzan.moonspace.core.data.local.entity.UpcomingLaunchWithBookmarkStatus
import com.septalfauzan.moonspace.core.data.remote.response.ProgramItem
import com.septalfauzan.moonspace.core.data.remote.response.RocketLaunchItem
import com.septalfauzan.moonspace.core.helper.DataMapper.toCompleteRocketLaunchSchedule
import com.septalfauzan.moonspace.core.helper.DataMapper.toRocketLaunchProgram
import com.septalfauzan.moonspace.core.helper.DataMapper.toRocketLaunchSchedules
import com.septalfauzan.moonspace.core.helper.DataMapper.toUpcomingLaunchEntity
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test

class DataMapperTest {

    @Test
    fun toUpcomingLaunchEntity() {
        val emptyUpcomingLaunch = RocketLaunchItem().toUpcomingLaunchEntity()
        assertEquals("-", emptyUpcomingLaunch.id)
    }

    @Test
    fun toRocketLaunchSchedule() {
        val upcomingLaunchEntity = UpcomingLaunchEntity(
            id = "",
            name = "rocket 1",
            windowStart = "-",
            image = "-",
            latitude = null,
            longitude = null
        )
        val upcomingLaunchWithBookmarkStatus =
            UpcomingLaunchWithBookmarkStatus(upcomingLaunch = upcomingLaunchEntity, bookmark = null)

        assertEquals("rocket 1", upcomingLaunchWithBookmarkStatus.upcomingLaunch.name)
    }

    @Test
    fun toRocketLaunchScheduleBookmarkNull() {
        val upcomingLaunchEntity = UpcomingLaunchEntity(
            id = "",
            name = "rocket 1",
            windowStart = "-",
            image = "-",
            latitude = null,
            longitude = null
        )
        val upcomingLaunchWithBookmarkStatus =
            UpcomingLaunchWithBookmarkStatus(upcomingLaunch = upcomingLaunchEntity, bookmark = null)

        assertNull(upcomingLaunchWithBookmarkStatus.bookmark)
    }

    @Test
    fun toRocketLaunchProgram() {
        val programItem = ProgramItem()
        val result = programItem.toRocketLaunchProgram()

        assertEquals("-", result.name)
    }

    @Test
    fun toRocketLaunchProgramNotNull() {
        val programItem = ProgramItem()
        val result = programItem.toRocketLaunchProgram()

        assertNotNull(result.name)
    }

    @Test
    fun toCompleteRocketLaunchSchedule() {
        val rocketLaunchEntity = RocketLaunchItem()
        val result = rocketLaunchEntity.toCompleteRocketLaunchSchedule()
        assertEquals("-", result.imageUrl)
    }

    @Test
    fun toCompleteRocketLaunchScheduleNotNull() {
        val rocketLaunchEntity = RocketLaunchItem()
        val result = rocketLaunchEntity.toCompleteRocketLaunchSchedule()
        assertNotNull(result.imageUrl)
    }

    @Test
    fun toRocketLaunchSchedules() {
        val upcomingLaunchEntity = UpcomingLaunchEntity(
            id = "",
            name = "rocket 1",
            windowStart = "-",
            image = "-",
            latitude = null,
            longitude = null
        )
        val upcomingLaunchWithBookmarkStatus =
            UpcomingLaunchWithBookmarkStatus(upcomingLaunch = upcomingLaunchEntity, bookmark = null)
        val listUpcomingLaunchEntities = listOf(upcomingLaunchWithBookmarkStatus, upcomingLaunchWithBookmarkStatus, upcomingLaunchWithBookmarkStatus)
        val result = listUpcomingLaunchEntities.toRocketLaunchSchedules()

        assertEquals(listUpcomingLaunchEntities.size, result.size)
        assertNull(listUpcomingLaunchEntities[0].bookmark)
    }
}