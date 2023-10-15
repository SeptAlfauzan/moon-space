package com.septalfauzan.moonspace.core.data

import com.septalfauzan.moonspace.core.data.local.LocalDataSource
import com.septalfauzan.moonspace.core.data.local.entity.BookmarkLaunchEntity
import com.septalfauzan.moonspace.core.data.remote.RemoteDataSource
import com.septalfauzan.moonspace.core.data.remote.network.ApiResponse
import com.septalfauzan.moonspace.core.data.remote.response.RocketLaunchItem
import com.septalfauzan.moonspace.core.domain.model.RocketLaunchSchedule
import com.septalfauzan.moonspace.core.domain.repository.InterfaceRocketLaunchRepository
import com.septalfauzan.moonspace.core.helper.DataMapper.toCompleteRocketLaunchSchedule
import com.septalfauzan.moonspace.core.helper.DataMapper.toUpcomingLaunchEntity
import com.septalfauzan.moonspace.core.helper.DataMapper.toRocketLaunchSchedules
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RocketLaunchRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : InterfaceRocketLaunchRepository {
    override fun getAllUpcomingLaunch(): Flow<Resource<List<RocketLaunchSchedule>>> =
        object : NetworkBoundResource<List<RocketLaunchSchedule>, List<RocketLaunchItem>>() {
            override fun loadFromDB(): Flow<List<RocketLaunchSchedule>> {
                return localDataSource.getAllUpcomingLaunch().map { it.toRocketLaunchSchedules() }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<RocketLaunchItem>>> {
                return remoteDataSource.getAllUpcomingLaunch()
            }

            override suspend fun saveCallResult(data: List<RocketLaunchItem>) {
                val upcomingLaunchEntities = data.map { it.toUpcomingLaunchEntity() }
                localDataSource.insertUpcomingLaunch(upcomingLaunchEntities)
            }

            override fun shouldFetch(data: List<RocketLaunchSchedule>?): Boolean =
                data == null || data.isEmpty()
        }.asFlow()

    override fun getAllBookmarkedUpcomingLaunch(): Flow<Resource<List<RocketLaunchSchedule>>> = flow {
        emit(Resource.Loading())
        try {
            val result = localDataSource.getAllBookmarkedLaunch().map { it.toRocketLaunchSchedules() }
            emitAll(result.map { Resource.Success(it) })
        }catch (e: java.lang.Exception){
            emit(Resource.Error(e.message.toString()))
        }
    }

    override fun getFilteredUpcomingLaunch(key: String): Flow<Resource<List<RocketLaunchSchedule>>>  = flow{
        val raw = localDataSource.getAllUpcomingLaunch().map { it.toRocketLaunchSchedules() }
        emitAll(raw.map {  Resource.Success(it.filter { item -> item.name.lowercase().contains(key) }) })
    }

    override fun getFilteredBookmarkedUpcomingLaunch(key: String): Flow<Resource<List<RocketLaunchSchedule>>> = flow{
        val raw = localDataSource.getAllBookmarkedLaunch().map { it.toRocketLaunchSchedules() }
        emitAll(raw.map { Resource.Success(it.filter { item -> item.name.lowercase().contains(key) }) })
    }

    override fun getDetailLaunch(id: String): Flow<Resource<RocketLaunchSchedule>> = flow {
        emit(Resource.Loading())
        val request = remoteDataSource.getDetailLaunch(id)
        val bookmarkStatus = localDataSource.getBookmark(id).first()
        when (val apiResponse = request.first()) {
            is ApiResponse.Success -> emit(
                    Resource.Success(
                        apiResponse.data.toCompleteRocketLaunchSchedule().apply { bookmarked = bookmarkStatus != null })
                )
            is ApiResponse.Error -> emit(Resource.Error(apiResponse.errorMessage))
            is ApiResponse.Empty -> emit(Resource.Error("No data"))
        }
    }

    override fun getBookmarkStatus(id: String): Flow<Boolean> = flow {
        val result = localDataSource.getBookmark(id)
        emitAll(result.map { it != null })
    }

    override fun updateBookmark(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val bookmarked = localDataSource.getBookmark(id).first()

            val currentDateTime = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            val formattedDateTime = currentDateTime.format(formatter)

            val bookmark = BookmarkLaunchEntity(launchId = id, bookmarkedAt = formattedDateTime)
            when (bookmarked) {
                null -> localDataSource.insertBookmark(bookmark)
                else -> localDataSource.deleteBookmark(bookmarked)
            }
        }
    }

}