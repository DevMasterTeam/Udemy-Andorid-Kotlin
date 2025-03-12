package com.devmasterteam.programandointerface.business

class UserBusiness {
    fun checkCredentials(email: String, password: String): Boolean {
        return "" != email && "" != password
    }
}
