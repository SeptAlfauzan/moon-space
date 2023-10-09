package com.septalfauzan.moonspace.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class GetUpcomingLaunchResponse(

	@field:SerializedName("next")
	val next: String? = null,

	@field:SerializedName("previous")
	val previous: Any? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("results")
	val results: List<RocketLaunchItem>
)