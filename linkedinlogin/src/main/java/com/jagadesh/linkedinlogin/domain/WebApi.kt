package com.jagadesh.linkedinlogin.domain

import com.jagadesh.linkedinlogin.data.AccessTokenResponse
import com.jagadesh.linkedinlogin.data.UserEmailResponse
import com.jagadesh.linkedinlogin.data.UserListResponse
import com.jagadesh.linkedinlogin.domain.ApiParam.AUTHORIZATION
import com.jagadesh.linkedinlogin.domain.ApiParam.CONTENT_TYPE
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.QueryMap
import java.util.*

interface WebApi {
    @GET("userinfo")
    fun callUserDetailsApi(@Header(AUTHORIZATION) authorization: String): Call<UserListResponse>

    @GET("emailAddress?q=members&projection=(elements*(handle~))")
    fun callUserEmailApi(@Header(AUTHORIZATION) authorization: String): Call<UserEmailResponse>

    @POST("accessToken")
    fun callAccessTokenApi(@Header(CONTENT_TYPE) authorization: String, @QueryMap hashMap: HashMap<String, String>): Call<AccessTokenResponse>
}