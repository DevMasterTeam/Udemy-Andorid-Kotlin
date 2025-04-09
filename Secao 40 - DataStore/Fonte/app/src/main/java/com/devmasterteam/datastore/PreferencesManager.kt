package com.devmasterteam.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

// Atenação ao instanciar um DataStore.
// Caso haja duas instâncias, vai falhar, pois o dataStore precisa ser único.
// Nesse caso, o melhor a se fazer, é tornar a classe singleton ou definir a variável acima da classe.
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class PreferencesManager (private val context: Context) {

    /**
     * Recebe uma chave e armazena o valor no DataStore
     * */
    suspend fun save(key: String, value: String) {
        val preferencesKey = stringPreferencesKey(key)
        context.dataStore.edit { preferences -> preferences[preferencesKey] = value }
    }

    /**
     * Faz a leitura do valor associada a chave
     * */
    suspend fun read(key: String): String {
        val preferencesKey = stringPreferencesKey(key)
        val data = context.dataStore.data.first()

        return data[preferencesKey] ?: ""
    }

    /**
     * Remove chave e valor do DataStore
     * */
    suspend fun remove(key: String) {
        val preferencesKey = stringPreferencesKey(key)
        context.dataStore.edit { preferences -> preferences.remove(preferencesKey) }
    }

    // O uso do Flow faz com que o código seja notificado quando houver uma alteração em dataStore (comum na programação reativa).
    suspend fun readUsingFlow(key: String) {
        val preferencesKey = stringPreferencesKey(key)
        val exampleFlow: Flow<String> =
            context.dataStore.data.map { pref -> pref[preferencesKey] ?: "" }

        exampleFlow.collect { value ->
            val s = value
        }
    }

}