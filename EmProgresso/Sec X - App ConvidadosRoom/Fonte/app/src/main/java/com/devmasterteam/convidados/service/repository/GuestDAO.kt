package com.devmasterteam.convidados.service.repository

import androidx.room.*
import com.devmasterteam.convidados.service.model.GuestModel

@Dao
interface GuestDAO {
    @Insert
    fun save(guest: GuestModel): Long

    @Update
    fun update(guest: GuestModel): Int

    @Delete
    fun delete(guest: GuestModel)

    @Query("SELECT * FROM Guest WHERE id = :id")
    fun load(id: Int): GuestModel

    @Query("SELECT * FROM Guest")
    fun getInvited(): List<GuestModel>

    @Query("SELECT * FROM Guest WHERE presence = 1")
    fun getPresent(): List<GuestModel>

    @Query("SELECT * FROM Guest WHERE presence = 0")
    fun getAbsent(): List<GuestModel>
}