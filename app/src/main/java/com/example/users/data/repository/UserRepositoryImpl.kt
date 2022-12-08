package com.example.users.data.repository

import com.example.data.datasource.UserDataSource
import com.example.data.repository.UserRepository
import com.example.domain.User

class UserRepositoryImpl(private val userDataSource: UserDataSource) : UserRepository {
    override suspend fun getUsers(): List<User> = userDataSource.getUsers()
}