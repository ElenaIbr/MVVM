package com.ibraeva.mvvm.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ibraeva.data.repository.UserRepositoryImpl
import com.ibraeva.data.storage.SharedPrefUserStorage
import com.ibraeva.domain.models.SaveUsername
import com.ibraeva.domain.usercases.GetUsernameUseCase
import com.ibraeva.domain.usercases.SaveUsernameUseCase

class MainViewModel(
    private val getUsernameUseCase: GetUsernameUseCase,
    private val saveUsernameUseCase: SaveUsernameUseCase
) : ViewModel() {

    val resultLive = MutableLiveData<String>()

    fun save(text: String) {
        val saveUsername = SaveUsername(name = text)
        val result: Boolean = saveUsernameUseCase.execute(saveUsername)
        resultLive.value = "Result is $result"
    }

    fun load() {
        val userName = getUsernameUseCase.execute()
        resultLive.value = userName.firstName + " " + userName.lastName
    }
}