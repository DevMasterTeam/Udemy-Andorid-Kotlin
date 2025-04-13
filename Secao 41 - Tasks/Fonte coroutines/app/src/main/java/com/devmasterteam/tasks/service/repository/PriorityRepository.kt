package com.devmasterteam.tasks.service.repository

import android.content.Context
import com.devmasterteam.tasks.service.model.PriorityModel
import com.devmasterteam.tasks.service.repository.local.TaskDatabase
import com.devmasterteam.tasks.service.repository.remote.PriorityService
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class PriorityRepository(context: Context) : BaseRepository(context) {

    private val remote = RetrofitClient.getService(PriorityService::class.java)
    private val database = TaskDatabase.getDatabase(context).priorityDAO()

    companion object {
        private val cache = mutableMapOf<Int, String>()
        fun getCachedDescription(id: Int): String {
            return cache[id] ?: ""
        }

        fun setCachedDescription(id: Int, str: String) {
            cache[id] = str
        }
    }

    fun list(): Flow<List<PriorityModel>> {
        return database.list()
    }

    suspend fun listAPI(): Response<List<PriorityModel>> {
        return safeApiCall { remote.list() }
    }

    /**
     * Obtém a descrição da tarefa, sempre buscando no cache antes do banco de dados
     * */
    fun getDescription(id: Int): String {
        val cached = getCachedDescription(id)
        return if (cached == "") {
            val description = database.getDescription(id)
            setCachedDescription(id, description)
            description
        } else {
            cached
        }
    }

    /**
     * Cria uma nova tarefa
     * */
    suspend fun save(list: List<PriorityModel>) {
        database.clear()
        database.save(list)
    }

}