package com.icyyoung.fourm.data.model

import com.google.gson.annotations.SerializedName

data class IndexResponse(
    @SerializedName("user") val user: User?,
    @SerializedName("posts") val posts: List<Post>,
    @SerializedName("topped_posts") val toppedPosts: List<Post>,
    @SerializedName("stats") val stats: Stats
)