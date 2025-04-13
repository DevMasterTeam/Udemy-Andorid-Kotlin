package com.devmasterteam.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.devmasterteam.tasks.service.constants.TaskConstants
import com.devmasterteam.tasks.service.exception.NoInternetException
import com.devmasterteam.tasks.service.model.ValidationModel
import com.devmasterteam.tasks.service.repository.PersonRepository
import com.devmasterteam.tasks.service.repository.local.PreferencesManager
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient
import kotlinx.coroutines.launch

class RegisterViewModel(application: Application) : BaseAndroidViewModel(application) {

    private val personRepository = PersonRepository(application.applicationContext)
    private val preferencesManager = PreferencesManager(application.applicationContext)

    private val _user = MutableLiveData<ValidationModel>()
    val user: LiveData<ValidationModel> = _user

    fun create(name: String, email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = personRepository.create(name, email, password)
                if (response.isSuccessful && response.body() != null) {
                    val result = response.body()!!

                    // Armazena os dados do usuário
                    preferencesManager.store(TaskConstants.SHARED.TOKEN_KEY, result.token)
                    preferencesManager.store(TaskConstants.SHARED.PERSON_KEY, result.personKey)
                    preferencesManager.store(TaskConstants.SHARED.PERSON_NAME, result.name)

                    // Headers que garantem a autenticação do usuário
                    RetrofitClient.addHeaders(result.token, result.personKey)

                    // Retorna sucesso
                    _user.value = ValidationModel()
                } else {
                    _user.value = eErrorMessageFromResponse(response)
                }
            } catch (e: NoInternetException) {
                _user.value = handleException(e)
            }
        }
    }
}