package com.devmasterteam.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devmasterteam.convidados.service.model.GuestModel
import com.devmasterteam.convidados.service.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    // Acesso a dados
    private val guestRepository: GuestRepository = GuestRepository(application.applicationContext)

    private var _saveGuest = MutableLiveData<Boolean>()
    val saveGuest: LiveData<Boolean> = _saveGuest

    private var _guest = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = _guest

    /**
     * Salva convidado
     * */
    fun save(id: Int, name: String, presence: Boolean) {
        val guest = GuestModel().apply {
            this.id = id
            this.name = name
            this.presence = presence
        }

        if (id == 0) {
            _saveGuest.value = guestRepository.save(guest)
        } else {
            _saveGuest.value = guestRepository.update(guest)
        }
    }

    /**
     * Carrega convidado
     * */
    fun load(id: Int) {
        _guest.value = guestRepository.get(id)
    }

}