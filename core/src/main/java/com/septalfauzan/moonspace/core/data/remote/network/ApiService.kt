package com.septalfauzan.moonspace.core.data.remote.network

import com.septalfauzan.moonspace.core.data.remote.response.GetUpcomingLaunchResponse
import com.septalfauzan.moonspace.core.data.remote.response.RocketLaunchItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("launch/upcoming")
    suspend fun getUpComing(@Query("format") format: String = "json") : GetUpcomingLaunchResponse

    @GET("launch/{id}")
    suspend fun getDetailLaunch(@Path("id") id: String) : RocketLaunchItem
}