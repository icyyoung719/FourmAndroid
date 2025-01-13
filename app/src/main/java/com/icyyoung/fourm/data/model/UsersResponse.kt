package com.icyyoung.fourm.data.model

import com.google.gson.annotations.SerializedName

data class UsersResponse(
    @SerializedName("user_list") val users: List<User>,
    // the logged in user
    @SerializedName("user") val user: User?
)