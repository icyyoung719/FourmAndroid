package com.icyyoung.fourm.data.model

import com.google.gson.annotations.SerializedName

data class PostDetailResponse (
    @SerializedName("post") val post: Post,
    @SerializedName("comments") val comments: List<Comment>
)