package com.dk.core.data.source.remote.reponse

import com.google.gson.annotations.SerializedName

data class CreditsResponse (
        @field:SerializedName("cast")
        val cast: List<CastResponse>
        )