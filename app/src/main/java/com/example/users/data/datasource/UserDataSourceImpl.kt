package com.example.users.data.datasource

import com.example.data.datasource.UserDataSource
import com.example.domain.User
import com.example.users.data.server.UserDb

class UserDataSourceImpl : UserDataSource {
    override suspend fun getUsers(): List<User> =
        UserDb.service
            .getUsers()
            .results
}