package com.dk.core.data.source.remote.network

import com.dk.core.BuildConfig.API_KEY
import com.dk.core.data.source.remote.reponse.BaseResponse
import com.dk.core.data.source.remote.reponse.CreditsResponse
import com.dk.core.data.source.remote.reponse.tv.TvItemResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvApiService {
    @GET("/tv/airing_today")
    suspend fun getAiringToday(
        @Query("api_key")
        apiKey: String = API_KEY,
        @Query("page")
        page: Int = 1
    ): BaseResponse<TvItemResponse>

    @GET("/tv/on_the_air")
    suspend fun getOnTheAir(
        @Query("api_key")
        apiKey: String = API_KEY,
        @Query("page")
        page: Int = 1
    ): BaseResponse<TvItemResponse>

    @GET("/tv/popular")
    suspend fun getPopular(
        @Query("api_key")
        apiKey: String = API_KEY,
        @Query("page")
        page: Int = 1
    ): BaseResponse<TvItemResponse>


    @GET("/tv/top_rated")
    suspend fun getTopRated(
        @Query("api_key")
        apiKey: String = API_KEY,
        @Query("page")
        page: Int = 1
    ): BaseResponse<TvItemResponse>

    @GET("/tv/{tv_id}")
    suspend fun getDetail(
        @Path("tv_id")
        id: Int,
        @Query("api_key")
        apiKey: String = API_KEY,
    ): TvItemResponse

    @GET("/tv/{tv_id}/credits")
    suspend fun getCredits(
        @Path("tv_id")
        id: Int,
        @Query("api_key")
        apiKey: String = API_KEY
    ): CreditsResponse

    @GET("/search/tv")
    suspend fun searchTv(

        @Query("query")
        query: String,
        @Query("api_key")
        apiKey: String = API_KEY,
        @Query("page")
        page: Int = 1
    ): BaseResponse<TvItemResponse>




}