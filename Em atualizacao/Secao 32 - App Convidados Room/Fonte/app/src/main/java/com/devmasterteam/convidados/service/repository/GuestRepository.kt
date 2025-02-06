package com.devmasterteam.convidados.service.repository

import android.content.Context
import com.devmasterteam.convidados.service.model.GuestModel

class GuestRepository (context: Context) {

    // Acesso ao banco de dados
    private val dataBase = GuestDatabase.getDatabase(context).guestDAO()

    /**
     * Carrega convidado
     */
    fun get(id: Int): GuestModel {
        return dataBase.load(id)
    }

    /**
     * Insere convidado
     */
    fun save(guest: GuestModel): Boolean {
        return dataBase.save(guest) > 0
    }

    /**
     * Faz a listagem de todos os convidados
     */
    fun getAll(): List<GuestModel> {
        return dataBase.getInvited()
    }

    /**
     * Faz a listagem de todos os convidados presentes
     */
    fun getPresent(): List<GuestModel> {
        return dataBase.getPresent()
    }

    /**
     * Faz a listagem de todos os convidados presentes
     */
    fun getAbsent(): List<GuestModel> {
        return dataBase.getAbsent()
    }

    /**
     * Atualiza convidado
     */
    fun update(guest: GuestModel): Boolean {
        return dataBase.update(guest) > 0
    }

    /**
     * Remove convidado
     */
    fun delete(guest: GuestModel) {
        dataBase.delete(guest)
    }

}