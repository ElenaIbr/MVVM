package com.ibraeva.data.repository

import com.ibraeva.data.storage.User
import com.ibraeva.data.storage.UserStorage
import com.ibraeva.domain.models.SaveUsername
import com.ibraeva.domain.models.UserName
import com.ibraeva.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(param: SaveUsername): Boolean {
        val user = User(firstName = param.name, lastName = "")

        val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.get()

        val userName = UserName(user.firstName, user.lastName)
        return userName
    }

}