package com.ibraeva.mvvm.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ibraeva.data.repository.UserRepositoryImpl
import com.ibraeva.data.storage.SharedPrefUserStorage
import com.ibraeva.domain.usercases.GetUsernameUseCase
import com.ibraeva.domain.usercases.SaveUsernameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepository by lazy {
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context))
    }
    private val getUsernameUseCase by lazy { GetUsernameUseCase(userRepository) }
    private val saveUsernameUseCase by lazy { SaveUsernameUseCase(userRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUsernameUseCase = getUsernameUseCase,
            saveUsernameUseCase = saveUsernameUseCase
        ) as T
    }
}