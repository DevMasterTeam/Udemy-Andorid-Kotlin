package com.devmasterteam.mybooks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devmasterteam.mybooks.entity.BookEntity
import com.devmasterteam.mybooks.repository.BookRepository

class BookDetailsViewModel(application: Application) : AndroidViewModel(application) {

    // Acesso a dados
    private val repository = BookRepository.getInstance()

    // Livro que será carregado
    private val _book = MutableLiveData<BookEntity>()
    val book: LiveData<BookEntity> = _book

    // Livro que será removido
    private val _bookDeleted = MutableLiveData<Boolean>()
    val bookDeleted: LiveData<Boolean> = _bookDeleted

    /**
     * Carrega livro do repositório
     * */
    fun getBook(bookId: Int) {
        _book.value = repository.getBookById(bookId)
    }

    /**
     * Atualiza boolean de favorito
     * */
    fun favorite(bookId: Int) {
        repository.toggleFavoriteStatus(bookId)
    }

    /**
     * Faz a remoção do libro por ID
     * */
    fun delete(bookId: Int) {
        _bookDeleted.value = repository.deleteBook(bookId)
    }

}