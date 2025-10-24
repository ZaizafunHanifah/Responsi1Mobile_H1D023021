package com.example.responsi1mobile_h1d023021.api

import com.example.responsi1mobile_h1d023021.model.TeamResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {
    @Headers("X-Auth-Token: 539954f3da08459a843c4cbd4982c5ee")
    @GET("teams/{id}")
    suspend fun getTeam(@Path("id") id: Int): TeamResponse
}