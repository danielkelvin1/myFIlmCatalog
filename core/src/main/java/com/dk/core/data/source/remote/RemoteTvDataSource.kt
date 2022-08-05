package com.dk.core.data.source.remote

import android.util.Log
import com.dk.core.data.source.remote.network.ApiResponse
import com.dk.core.data.source.remote.network.TvApiService
import com.dk.core.data.source.remote.reponse.CastResponse
import com.dk.core.data.source.remote.reponse.tv.TvItemResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteTvDataSource(private val apiService: TvApiService) {
    suspend fun getAiringToday(): Flow<ApiResponse<List<TvItemResponse>>>{
        return flow{
            try{
                val response = apiService.getAiringToday()
                val data = response.results
                if(data.isEmpty()){
                    emit(ApiResponse.Success(data))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e(REMOTE_TV, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getOnTheAir(): Flow<ApiResponse<List<TvItemResponse>>>{
        return flow{
            try{
                val response = apiService.getOnTheAir()
                val data = response.results
                if(data.isEmpty()){
                    emit(ApiResponse.Success(data))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e(REMOTE_TV, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getPopular(): Flow<ApiResponse<List<TvItemResponse>>>{
        return flow{
            try{
                val response = apiService.getAiringToday()
                val data = response.results
                if(data.isEmpty()){
                    emit(ApiResponse.Success(data))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e(REMOTE_TV, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getTopRated(): Flow<ApiResponse<List<TvItemResponse>>>{
        return flow{
            try{
                val response = apiService.getAiringToday()
                val data = response.results
                if(data.isEmpty()){
                    emit(ApiResponse.Success(data))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e(REMOTE_TV, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getDetail(id: Int): Flow<ApiResponse<TvItemResponse>>{
        return flow{
            try{
                val response = apiService.getDetail(id)
                val data = response
                emit(ApiResponse.Success(data))
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e(REMOTE_TV, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getCredits(id: Int): Flow<ApiResponse<List<CastResponse>>>{
        return flow{
            try{
                val response = apiService.getCredits(id)
                val data = response.cast
                if(data.isEmpty()){
                    emit(ApiResponse.Success(data))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e(REMOTE_TV, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun search(query: String): Flow<ApiResponse<List<TvItemResponse>>>{
        return flow{
            try{
                val response = apiService.searchTv(query)
                val data = response.results
                if(data.isEmpty()){
                    emit(ApiResponse.Success(data))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e(REMOTE_TV, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    companion object{
        private val REMOTE_TV = "remote tv"
    }
}