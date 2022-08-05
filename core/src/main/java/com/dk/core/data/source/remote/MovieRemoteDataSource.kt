package com.dk.core.data.source.remote

import android.util.Log
import com.dk.core.data.source.remote.network.ApiResponse
import com.dk.core.data.source.remote.network.MoviesApiService
import com.dk.core.data.source.remote.reponse.CastResponse
import com.dk.core.data.source.remote.reponse.CreditsResponse
import com.dk.core.data.source.remote.reponse.movies.MoviesItemResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MovieRemoteDataSource( private val apiService: MoviesApiService ) {
    suspend fun getNowPlaying(): Flow<ApiResponse<List<MoviesItemResponse>>>{
        return flow {
            try{
                val response = apiService.getNowPlaying()
                val data = response.results
                if(data.isNotEmpty()){
                    emit(ApiResponse.Success(data))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e(REMOTE_MOVIE, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getTopRated(): Flow<ApiResponse<List<MoviesItemResponse>>> {
        return flow {
            try {
                val response = apiService.getTopRated()
                val data = response.results
                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e(REMOTE_MOVIE, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getUpcoming(): Flow<ApiResponse<List<MoviesItemResponse>>> {
        return flow {
            try {
                val response = apiService.getUpcoming()
                val data = response.results
                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e(REMOTE_MOVIE, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getDetail(id: Int): Flow<ApiResponse<MoviesItemResponse>> {
        return flow {
            try {
                val response = apiService.getDetails(id)
                val data = response
                emit(ApiResponse.Success(data))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e(REMOTE_MOVIE, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getCredits(id: Int): Flow<ApiResponse<List<CastResponse>>>{
        return flow {
            try{
                val response = apiService.getCredits(id)
                val data = response.cast
                if(data.isNotEmpty()){
                    emit(ApiResponse.Success(data))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e(REMOTE_MOVIE, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun search(query: String): Flow<ApiResponse<List<MoviesItemResponse>>>{
        return flow {
            try{
                val response = apiService.searchMovie(query)
                val data = response.results
                if(data.isNotEmpty()){
                    emit(ApiResponse.Success(data))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e(REMOTE_MOVIE, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    companion object{
        private val REMOTE_MOVIE = "RemoteMoviesDataSource"
    }

}
