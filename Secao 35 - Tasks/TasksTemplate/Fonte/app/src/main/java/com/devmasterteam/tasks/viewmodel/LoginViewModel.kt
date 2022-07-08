package com.devmasterteam.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    /**
     * Faz login usando API
     */
    fun doLogin(email: String, password: String) {
    }

    /**
     * Verifica se usuário está logado
     */
    fun verifyLoggedUser() {
    }

}