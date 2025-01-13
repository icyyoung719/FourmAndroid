package com.icyyoung.fourm.data.api

import com.icyyoung.fourm.data.model.IndexResponse
import com.icyyoung.fourm.data.model.PostDetailResponse
import com.icyyoung.fourm.data.model.UserProfileResponse
import com.icyyoung.fourm.data.model.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("index/")
    suspend fun getIndex(): IndexResponse

    @GET("users/")
    suspend fun getUsers(): UsersResponse

    @GET("post/{id}/")
    suspend fun getPostDetail(@Path("id") id: Int): PostDetailResponse

    @GET("user/{id}/")
    suspend fun getUserDetail(@Path("id") id: Int): UserProfileResponse
}