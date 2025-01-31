package com.devmasterteam.tasks.service.repository.local

import android.annotation.SuppressLint
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class PreferencesManager private constructor(private val context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    companion object {
        @SuppressLint("StaticFieldLeak")
        private lateinit var INSTANCE: PreferencesManager

        // Método para obter a instância do singleton
        fun getInstance(context: Context): PreferencesManager {
            if (!::INSTANCE.isInitialized) {
                synchronized(this) {
                    INSTANCE = PreferencesManager(context.applicationContext)
                }
            }
            return INSTANCE
        }
    }

    /**
     * Recebe uma chave e armazena o valor no DataStore
     * */
    suspend fun store(key: String, value: String) {
        val preferencesKey = stringPreferencesKey(key)
        context.dataStore.edit { preferences -> preferences[preferencesKey] = value }
    }

    /**
     * Remove uma chave do DataStore
     * */
    suspend fun remove(key: String) {
        val preferencesKey = stringPreferencesKey(key)
        context.dataStore.edit { preferences -> preferences.remove(preferencesKey) }
    }

    /**
     * Faz a leitura do valor associada a chave
     * */
    suspend fun get(key: String): String {
        val preferencesKey = stringPreferencesKey(key)
        val data = context.dataStore.data.first()

        return data[preferencesKey] ?: ""
    }

}