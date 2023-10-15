package com.septalfauzan.moonspace.core.data

import com.septalfauzan.moonspace.core.data.local.LocalDataSource
import com.septalfauzan.moonspace.core.data.local.entity.BookmarkLaunchEntity
import com.septalfauzan.moonspace.core.data.local.entity.UpcomingLaunchEntity
import com.septalfauzan.moonspace.core.data.local.entity.UpcomingLaunchWithBookmarkStatus
import com.septalfauzan.moonspace.core.data.remote.RemoteDataSource
import com.septalfauzan.moonspace.core.domain.repository.IRocketLaunchRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class RocketLaunchRepositoryTest {

    @Mock
    private lateinit var rocketLaunchRepository: IRocketLaunchRepository

    @Mock
    private lateinit var remoteDataSource: RemoteDataSource

    @Mock
    private lateinit var localDataSource: LocalDataSource

    //    private lateinit var bookmarkLaunchDAO: BookmarkLaunchDAO
//    private lateinit var upcomingLaunchDAO: UpcomingLaunchDAO
//    private lateinit var db: MoonSpaceDatabase
    private val ID = "1"
    private val upcomingLaunchEntity = UpcomingLaunchEntity(
        id = "",
        name = "rocket 1",
        windowStart = "-",
        image = "-",
        latitude = null,
        longitude = null
    )
    private val bookmarked = BookmarkLaunchEntity(ID, bookmarkedAt = "12-12-2023")
    private val upcomingLaunchList =
        (0..1).map {

            UpcomingLaunchWithBookmarkStatus(
                upcomingLaunch = UpcomingLaunchEntity(
                    id = it.toString(),
                    name = "rocket 1",
                    windowStart = "-",
                    image = "-",
                    latitude = null,
                    longitude = null
                ),
                bookmark = bookmarked
            )
        }

    @Before
    fun setup() {

//        `when`(localDataSource.getAllBookmarkedLaunch()).thenReturn(
//            flowOf(
//                upcomingLaunchList.filter { it.bookmark != null }
//            )
//        )

//        `when`(localDataSource.getBookmark(ID)).thenReturn(flowOf(upcomingLaunchList.filter { bookmarked != null && bookmarked.launchId == ID }.single()))


        rocketLaunchRepository = RocketLaunchRepository(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )
    }

//    @After
//    fun closeDb() {
//        db.close()
//    }

    @Test
    fun getAllUpcomingLaunch() = runBlocking {
//        `when`(localDataSource.getAllBookmarkedLaunch()).thenReturn(
//            flowOf(
//                upcomingLaunchList.filter { it.bookmark != null }
//            )
//        )
//
//        val result = rocketLaunchRepository.getAllBookmarkedUpcomingLaunch()
//        Mockito.verify(localDataSource).getAllBookmarkedLaunch()
//
//        println("result ${ result.first().data }}")
    }

    @Test
    fun getAllBookmarkedUpcomingLaunch() {
    }

    @Test
    fun getFilteredUpcomingLaunch() {
    }

    @Test
    fun getFilteredBookmarkedUpcomingLaunch() {
    }

    @Test
    fun getDetailLaunch() {
    }

    @Test
    fun getBookmarkStatus() {
    }

    @Test
    fun updateBookmark() {
    }
}