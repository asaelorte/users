package com.example.data.datasource

import com.example.domain.User

interface UserDataSource {
    suspend fun getUsers(): List<User>
}