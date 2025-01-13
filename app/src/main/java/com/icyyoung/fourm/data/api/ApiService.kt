package com.icyyoung.fourm.data.api

import com.icyyoung.fourm.data.model.IndexResponse
import com.icyyoung.fourm.data.model.Post
import com.icyyoung.fourm.data.model.UsersResponse
import retrofit2.http.GET

interface ApiService {

    @GET("index/")
    suspend fun getIndex(): IndexResponse

    @GET("users/")
    suspend fun getUsers(): UsersResponse
}