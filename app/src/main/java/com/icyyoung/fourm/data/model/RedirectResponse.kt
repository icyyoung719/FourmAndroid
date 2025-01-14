package com.icyyoung.fourm.data.model

import com.google.gson.annotations.SerializedName

data class RedirectResponse (
    @SerializedName("status") val status: Int? = 200,
    @SerializedName("message") val message: String? = null,
    @SerializedName("redirect_url") val redirectUrl: String? = null,
    @SerializedName("user") val data: User? = null
)