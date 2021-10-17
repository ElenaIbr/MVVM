package com.ibraeva.domain.usercases

import com.ibraeva.domain.models.SaveUsername
import com.ibraeva.domain.repository.UserRepository

class SaveUsernameUseCase(private val userRepository: UserRepository) {

    fun execute(safeUsername: SaveUsername): Boolean {
        return userRepository.saveName(param = safeUsername)
    }
}