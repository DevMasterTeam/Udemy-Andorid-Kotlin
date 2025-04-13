package com.devmasterteam.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.devmasterteam.tasks.service.constants.TaskConstants
import com.devmasterteam.tasks.service.repository.local.PreferencesManager
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val preferencesManager = PreferencesManager(application.applicationContext)

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    /**
     * Remove os dados do usuário armazenados nas preferências, efetivando o logout.
     */
    fun logout() {
        viewModelScope.launch {
            preferencesManager.remove(TaskConstants.SHARED.TOKEN_KEY)
            preferencesManager.remove(TaskConstants.SHARED.PERSON_KEY)
            preferencesManager.remove(TaskConstants.SHARED.PERSON_NAME)
        }
    }

    /**
     * Carrega o nome do usuário salvo nas preferências e atualiza o LiveData observado pela interface.
     */
    fun loadUserName() {
        viewModelScope.launch {
            _name.value = preferencesManager.get(TaskConstants.SHARED.PERSON_NAME)
        }
    }

}