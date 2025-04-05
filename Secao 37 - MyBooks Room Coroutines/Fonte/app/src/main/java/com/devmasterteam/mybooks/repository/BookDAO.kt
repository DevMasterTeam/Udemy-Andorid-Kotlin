package com.devmasterteam.mybooks.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.devmasterteam.mybooks.entity.BookEntity
import kotlinx.coroutines.flow.Flow

/**
 * Tipos de retorno possíveis
 * -----
 * Query
 * Entidade - Única linha da tabela
 * List<Entidade> - Lista de dados
 * LiveData<T> - LiveData Generics que pode ser observado
 * Flow<T> - Fluxo de dados usando Generics
 * Cursor - Cursor para iteração
 * int, long, boolean - A depender da consulta, os três valores também são possíveis
 * -----
 * Insert
 * Entidade - Única linha inserida na tabela
 * List<Entidade> - Lista de dados inseridos na tabela
 * long - Retorno do ID inserido (no caso de um auto-incremnto)
 * List<long> - Lista de IDs inseridos
 * -----
 * Update
 * Entidade - Única linha atualizada na tabela
 * List<Entidade> - Lista de dados atualizados na tabela
 * int - Número de linhas afetadas pela operação
 * -----
 * Delete
 * Entidade - Única linha removida da tabela
 * List<Entidade> - Lista de dados removidos da tabela
 * int - Número de linhas afetadas pela operação
 * */

@Dao
interface BookDAO {

    @Insert
    suspend fun create(book: List<BookEntity>)

    @Update
    suspend fun update(book: BookEntity): Int

    @Delete
    suspend fun delete(book: BookEntity): Int

    @Query("SELECT * FROM Book WHERE id = :id")
    suspend fun getBookById(id: Int): BookEntity

    @Query("SELECT * FROM Book")
    fun getAllBooks(): Flow<List<BookEntity>>

    @Query("SELECT * FROM Book WHERE favorite = 1")
    fun getFavoriteBooks(): Flow<List<BookEntity>>

}