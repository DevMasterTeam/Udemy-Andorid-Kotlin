package com.devmasterteam.mvvm

class PersonRepository {
    fun login(name: String): Boolean {
        return name != ""
    }
}