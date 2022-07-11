package com.devmasterteam.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var textWelcome = MutableLiveData<String>()
    private var toastNotification = MutableLiveData<String>()
    private val personRepository = PersonRepository()

    init {
        textWelcome.value = "Bom dia!"
    }

    fun welcome(): LiveData<String> {
        return textWelcome
    }

    fun login(): LiveData<String> {
        return toastNotification
    }

    fun doLogin(email: String) {
        if (this.personRepository.login(email))
            toastNotification.setValue("Success")
        else
            toastNotification.setValue("Falha")
    }

}