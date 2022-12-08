package com.example.data.repository

import com.example.domain.User

interface UserRepository {
    suspend fun getUsers(): List<User>
}