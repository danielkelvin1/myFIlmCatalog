package com.dk.core.data.source.remote.network

import com.dk.core.data.source.remote.reponse.BaseResponse
import com.dk.core.data.source.remote.reponse.CreditsResponse
import com.dk.core.data.source.remote.reponse.movies.MoviesItemResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import com.dk.core.BuildConfig.API_KEY

interface MoviesApiService {

    @GET("/movie/now_playing")
    suspend fun getNowPlaying(
        @Query("api_key")
        apiKey: String = API_KEY,
        @Query("page")
        page: Int = 1
    ): BaseResponse<MoviesItemResponse>

    @GET("/movie/popular")
    suspend fun getPopular(
        @Query("api_key")
        apiKey: String = API_KEY,
        @Query("page")
        page: Int = 1
    ): BaseResponse<MoviesItemResponse>

    @GET("/movie/top_rated")
    suspend fun getTopRated(
        @Query("api_key")
        apiKey: String = API_KEY,
        @Query("page")
        page: Int = 1
    ): BaseResponse<MoviesItemResponse>

    @GET("/movie/upcoming")
    suspend fun getUpcoming(
        @Query("api_key")
        apiKey: String = API_KEY,
        @Query("page")
        page: Int = 1
    ): BaseResponse<MoviesItemResponse>


    @GET("/movie/{movie_id}")
    suspend fun getDetails(
        @Path("movie_id")
        id: Int,
        @Query("api_key")
        apiKey: String = API_KEY,
    ): MoviesItemResponse

    @GET("/movie/{movie_id}/credits")
    suspend fun getCredits(
        @Path("movie_id")
        id: Int,
        @Query("api_key")
        apiKey: String = API_KEY
    ): CreditsResponse


    @GET("search/movie")
    suspend fun searchMovie(
        @Query("query")
        query: String,
        @Query("api_key")
        apiKey: String = API_KEY,
        @Query("page")
        page: Int = 1
    ): BaseResponse<MoviesItemResponse>
}