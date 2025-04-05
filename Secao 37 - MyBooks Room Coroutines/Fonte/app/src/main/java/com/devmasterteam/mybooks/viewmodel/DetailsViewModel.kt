package com.devmasterteam.mybooks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.devmasterteam.mybooks.entity.BookEntity
import com.devmasterteam.mybooks.repository.BookRepository
import kotlinx.coroutines.launch

class DetailsViewModel(application: Application) : AndroidViewModel(application) {

    // Acesso a dados
    private val repository = BookRepository.getInstance(application.applicationContext)

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
        viewModelScope.launch {
            _book.value = repository.getBookById(bookId)
        }
    }

    /**
     * Atualiza boolean de favorito
     * */
    fun favorite(bookId: Int) {
        viewModelScope.launch {
            repository.toggleFavoriteStatus(bookId)
        }
    }

    /**
     * Faz a remoção do libro por ID
     * */
    fun delete(bookId: Int) {
        viewModelScope.launch {
            _bookDeleted.value = repository.deleteBook(bookId)
        }
    }

}