package com.devmasterteam.mybooks.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.devmasterteam.mybooks.entity.BookEntity

@Dao
interface BookDAO {

    @Insert
    fun create(book: List<BookEntity>)

    @Update
    fun update(book: BookEntity): Int

    @Delete
    fun delete(book: BookEntity): Int

    @Query("SELECT * FROM Book WHERE id = :id")
    fun getBookById(id: Int): BookEntity

    @Query("SELECT * FROM Book")
    fun getAllBooks(): List<BookEntity>

    @Query("SELECT * FROM Book WHERE favorite = 1")
    fun getFavoriteBooks(): List<BookEntity>

}