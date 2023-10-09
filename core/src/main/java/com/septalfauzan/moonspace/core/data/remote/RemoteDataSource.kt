package com.septalfauzan.moonspace.core.data.remote

import com.septalfauzan.moonspace.core.data.remote.network.ApiResponse
import com.septalfauzan.moonspace.core.data.remote.network.ApiService
import com.septalfauzan.moonspace.core.data.remote.response.RocketLaunchItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getAllUpcomingLaunch() : Flow<ApiResponse<List<RocketLaunchItem>>>{
        return flow{
            try{
                val response = apiService.getUpComing()
                val data = response.results
                if(data.isNotEmpty()){
                    emit(ApiResponse.Success(data))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e: java.lang.Exception){
                    emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getDetailLaunch(id: String): Flow<ApiResponse<RocketLaunchItem>>{
        return flow<ApiResponse<RocketLaunchItem>> {
            try {
                val response = apiService.getDetailLaunch(id)
                emit(ApiResponse.Success(response))
            }catch (e: java.lang.Exception){
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}