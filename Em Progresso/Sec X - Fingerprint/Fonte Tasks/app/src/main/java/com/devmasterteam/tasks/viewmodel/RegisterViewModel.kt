package com.devmasterteam.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.AndroidViewModel
import com.devmasterteam.tasks.service.constants.TaskConstants
import com.devmasterteam.tasks.service.listener.APIListener
import com.devmasterteam.tasks.service.listener.ValidationListener
import com.devmasterteam.tasks.service.model.HeaderModel
import com.devmasterteam.tasks.service.repository.PersonRepository
import com.devmasterteam.tasks.service.repository.local.SecurityPreferences

class RegisterViewModel(application: Application) : AndroidViewModel(application) {

    // Criação usando API
    private val mCreate = MutableLiveData<ValidationListener>()
    val create: LiveData<ValidationListener> = mCreate

    // Acesso a dados
    private val mSecurityPreferences = SecurityPreferences(application)
    private val mRepository = PersonRepository(application)

    fun create(name: String, email: String, password: String) {
        mRepository.create(name, email, password, object : APIListener<HeaderModel> {
            override fun onSuccess(result: HeaderModel, statusCode: Int) {

                // Salvar dados do usuário no SharePreferences
                mSecurityPreferences.store(TaskConstants.SHARED.PERSON_KEY, result.personKey)
                mSecurityPreferences.store(TaskConstants.SHARED.TOKEN_KEY, result.token)
                mSecurityPreferences.store(TaskConstants.SHARED.PERSON_NAME, result.name)

                mCreate.value = ValidationListener()
            }

            override fun onFailure(message: String) {
                mCreate.value = ValidationListener(message)
            }

        })
    }

}