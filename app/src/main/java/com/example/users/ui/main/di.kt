package com.example.users.ui.main

import com.example.usecases.GetUserUseCase
import com.example.users.data.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class MainActivityModule {

    @Provides
    @ViewModelScoped
    fun getUserUseCasesProvider(userRepository: UserRepositoryImpl) =
        GetUserUseCase(userRepository)
}