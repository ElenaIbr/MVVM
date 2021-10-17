package com.ibraeva.domain.usercases

import com.ibraeva.domain.models.UserName
import com.ibraeva.domain.repository.UserRepository

class GetUsernameUseCase(private val userRepository: UserRepository) {
    fun execute(): UserName {
        return userRepository.getName()
    }
}