package com.dk.core.data.source.remote.reponse.tv

import com.dk.core.data.source.remote.reponse.Genre
import com.google.gson.annotations.SerializedName

data class TvItemResponse (
    @field:SerializedName("backdrop_path")
    val backdropPath: String? = "",

    @field:SerializedName("first_air_date")
    val firstAirDate: String? = "",

    @field:SerializedName("genres")
    val genres: List<Genre>,

    @field:SerializedName("id")
    val id: Int = 0,

    @field:SerializedName("name")
    val name: String? = "",

    @field:SerializedName("overview")
    val overview: String? = "",

    @field:SerializedName("popularity")
    val popularity: Double = 0.0,

    @field:SerializedName("poster_path")
    val posterPath: String? = "",

    @field:SerializedName("vote_count")
    val voteCount: Int = 0,

    @field:SerializedName("vote_average")
    val voteAverage: Double = 0.0
)