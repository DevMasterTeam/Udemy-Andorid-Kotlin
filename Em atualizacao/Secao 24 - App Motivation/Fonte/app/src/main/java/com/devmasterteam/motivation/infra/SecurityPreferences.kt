package com.devmasterteam.motivation.infra

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, value: String) {
        this.sharedPreferences.edit().putString(key, value).apply()
    }

    fun getStoredString(key: String): String {
        return this.sharedPreferences.getString(key, "") ?: ""
    }

}