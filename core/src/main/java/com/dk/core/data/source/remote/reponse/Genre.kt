package com.dk.core.data.source.remote.reponse

import com.google.gson.annotations.SerializedName

data class Genre (
    @field:SerializedName("name")
    val name: String
        )