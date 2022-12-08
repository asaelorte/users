package com.example.users.api

import com.example.domain.Users
import retrofit2.http.GET

interface UserApiService {
    @GET("api/?results=20")
    suspend fun getUsers(): Users
}