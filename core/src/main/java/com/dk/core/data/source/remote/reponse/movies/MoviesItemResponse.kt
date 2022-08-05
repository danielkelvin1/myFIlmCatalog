package com.dk.core.data.source.remote.reponse.movies

import com.dk.core.data.source.remote.reponse.Genre
import com.google.gson.annotations.SerializedName

data class MoviesItemResponse (
    @field:SerializedName("backdrop_path")
    val backdropPath: String? = "",

    @field:SerializedName("genres")
    val genres: List<Genre>,

    @field:SerializedName("id")
    val id: Int = 0,

    @field:SerializedName("overview")
    val overview: String? = "",

    @field:SerializedName("popularity")
    val popularity: Double = 0.0,

    @field:SerializedName("poster_path")
    val posterPath: String? = "",

    @field:SerializedName("release_date")
    val releaseDate: String? = "",

    @field:SerializedName("title")
    val title: String? = "",

    @field:SerializedName("vote_count")
    val voteCount: Int = 0,

    @field:SerializedName("runtime")
    val runtime: Int = 0,

    @field:SerializedName("vote_average")
    val voteAverage: Double = 0.0
        )