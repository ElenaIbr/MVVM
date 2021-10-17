package com.ibraeva.domain.repository

import com.ibraeva.domain.models.SaveUsername
import com.ibraeva.domain.models.UserName

interface UserRepository {
    fun saveName(param: SaveUsername): Boolean

    fun getName(): UserName
}