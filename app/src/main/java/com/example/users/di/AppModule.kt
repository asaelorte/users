package com.example.users.di

import com.example.data.datasource.UserDataSource
import com.example.users.data.datasource.UserDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun userDataSourceProvider(): UserDataSource = UserDataSourceImpl()
}