package com.ibraeva.data.storage

import android.content.Context


private const val SHARED_PREF_NAME = "shared_pref"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_NAME = "defaultName"


class SharedPrefUserStorage(context: Context): UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {

        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        return true
    }

    override fun get(): User {

        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME

        return User(firstName = firstName, lastName = lastName)
    }
}