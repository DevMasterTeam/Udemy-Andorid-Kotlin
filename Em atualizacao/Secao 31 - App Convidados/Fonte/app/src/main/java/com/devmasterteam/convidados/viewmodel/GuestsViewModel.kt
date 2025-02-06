package com.devmasterteam.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devmasterteam.convidados.service.constants.GuestConstants
import com.devmasterteam.convidados.service.model.GuestModel
import com.devmasterteam.convidados.service.repository.GuestRepository

class GuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application.applicationContext)

    private val _guestList = MutableLiveData<List<GuestModel>>()
    val guestList: LiveData<List<GuestModel>> = _guestList

    fun getAll() {
        _guestList.value = repository.getAll()
    }

    fun getAbsent() {
        _guestList.value = repository.getAbsent()
    }

    fun getPresent() {
        _guestList.value = repository.getPresent()
    }

    fun delete(id: Int) {
        repository.delete(id)
    }

}