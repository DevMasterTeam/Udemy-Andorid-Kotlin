package com.devmasterteam.tasks.service.repository

import android.content.Context
import com.devmasterteam.tasks.service.model.PersonModel
import com.devmasterteam.tasks.service.repository.remote.PersonService
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient
import retrofit2.Response

/**
 * Repositório responsável por gerenciar as operações relacionadas ao usuário (pessoa),
 * como login e cadastro, utilizando chamadas de API remotas.
 */
class PersonRepository(context: Context) : BaseRepository(context) {

    // Instância do serviço remoto que define os endpoints da API relacionados à pessoa
    private val remote = RetrofitClient.getService(PersonService::class.java)

    /**
     * Realiza o login de um usuário utilizando e-mail e senha.
     * Antes de executar, verifica se há conexão com a internet.
     */
    suspend fun login(email: String, password: String): Response<PersonModel> {
        return safeApiCall { remote.login(email, password) }
    }

    /**
     * Realiza o cadastro de um usuário utilizando e-mail, senha e nome.
     * Antes de executar, verifica se há conexão com a internet.
     */
    suspend fun create(name: String, email: String, password: String): Response<PersonModel> {
        return safeApiCall { remote.create(name, email, password) }
    }
}