package com.dk.core.data.source.remote.reponse

import com.google.gson.annotations.SerializedName


data class BaseResponse<T> (
        @field:SerializedName("page")
        val page: Int,
        @field:SerializedName("results")
        val results: List<T>
        )
