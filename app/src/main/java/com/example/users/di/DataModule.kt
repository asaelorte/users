package com.example.users.di

import com.example.data.datasource.UserDataSource
import com.example.users.data.repository.UserRepositoryImpl

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun userRepositoryProvider(
        userDataSource: UserDataSource
    ) = UserRepositoryImpl(userDataSource)
}