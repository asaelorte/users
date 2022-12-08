package com.example.usecases

import com.example.data.repository.UserRepository
import com.example.domain.User

class GetUserUseCase(private val userRepository: UserRepository) {
    suspend fun invoke(): List<User> = userRepository.getUsers()
}