package com.dk.core.data.source.remote.reponse

import com.google.gson.annotations.SerializedName

data class CastResponse(

	@field:SerializedName("character")
	val character: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("profile_path")
	val profilePath: String? = null,

	@field:SerializedName("id")
	val id: Int
)
