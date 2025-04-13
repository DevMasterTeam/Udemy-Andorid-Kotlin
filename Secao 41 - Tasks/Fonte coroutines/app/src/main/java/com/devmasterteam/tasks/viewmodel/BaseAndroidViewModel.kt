package com.devmasterteam.tasks.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.devmasterteam.tasks.R
import com.devmasterteam.tasks.service.exception.NoInternetException
import com.devmasterteam.tasks.service.model.ValidationModel
import com.google.gson.Gson
import retrofit2.Response

/**
 * ViewModel base que provê funcionalidades comuns para outras ViewModels do aplicativo.
 *
 * Esta classe fornece métodos auxiliares para tratamento de erros genéricos,
 * como exceções e respostas de erro da API, além de facilitar o acesso ao contexto da aplicação.
 */
open class BaseAndroidViewModel(private val app: Application) : AndroidViewModel(app) {

    /**
     * Extrai a mensagem de erro da resposta da API e encapsula em um ValidationModel.
     */
    fun <T> eErrorMessageFromResponse(response: Response<T>): ValidationModel {
        return ValidationModel(
            Gson().fromJson(
                response.errorBody()?.string().toString(),
                String::class.java
            )
        )
    }

    /**
     * Trata exceções lançadas durante chamadas de rede.
     * Caso a exceção seja do tipo NoInternetException, retorna uma mensagem específica.
     * Caso contrário, retorna uma mensagem genérica de erro inesperado.
     */
    fun handleException(e: Exception): ValidationModel {
        return if (e is NoInternetException) {
            ValidationModel(e.errorMessage)
        } else {
            ValidationModel(app.applicationContext.getString(R.string.error_unexpected))
        }
    }

}