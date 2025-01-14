package com.icyyoung.fourm.data.api

import com.icyyoung.fourm.data.model.IndexResponse
import com.icyyoung.fourm.data.model.LoginRequest
import com.icyyoung.fourm.data.model.PostDetailResponse
import com.icyyoung.fourm.data.model.RedirectResponse
import com.icyyoung.fourm.data.model.UserProfileResponse
import com.icyyoung.fourm.data.model.UsersResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
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

    @GET("settings/")
    suspend fun getSettings(): RedirectResponse

    @POST("register/")
    suspend fun postRegister(): RedirectResponse

    @POST("send_captcha/")
    suspend fun postSendCaptcha(): RedirectResponse

    @POST("login/")
    suspend fun postLogin(@Body loginRequest: LoginRequest): RedirectResponse

    @POST("create/")
    suspend fun postCreate(): RedirectResponse

    @POST("comment/")
    suspend fun postComment(): RedirectResponse

    @POST("logout/")
    suspend fun postLogout(): RedirectResponse

    @GET("settings/password/")
    suspend fun getSettingPassword(): RedirectResponse

    @POST("settings/password/")
    suspend fun postSettingPassword(): RedirectResponse

    @GET("find_password")
    suspend fun getFindPassword(): RedirectResponse

    @POST("find_password")
    suspend fun postFindPassword(): RedirectResponse
}