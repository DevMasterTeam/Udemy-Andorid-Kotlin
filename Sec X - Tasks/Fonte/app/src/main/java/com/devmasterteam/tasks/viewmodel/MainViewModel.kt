package com.devmasterteam.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devmasterteam.tasks.service.constants.TaskConstants
import com.devmasterteam.tasks.service.repository.local.SecurityPreferences

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val mPreferences = SecurityPreferences(application)

    private val mLogout = MutableLiveData<Boolean>()
    val logout: LiveData<Boolean> = mLogout

    private val mUserName = MutableLiveData<String>()
    val userName: LiveData<String> = mUserName

    fun logout() {
        mPreferences.remove(TaskConstants.SHARED.PERSON_KEY)
        mPreferences.remove(TaskConstants.SHARED.TOKEN_KEY)
        mPreferences.remove(TaskConstants.SHARED.PERSON_NAME)
        mLogout.value = true
    }

    fun loadUserName() {
        mUserName.value = mPreferences.get(TaskConstants.SHARED.PERSON_NAME)
    }

}