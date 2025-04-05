package com.devmasterteam.mybooks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.devmasterteam.mybooks.repository.BookRepository
import kotlinx.coroutines.launch

class FavoriteViewModel(application: Application) : AndroidViewModel(application) {

    // Acesso a dados
    private val repository = BookRepository.getInstance(application.applicationContext)

    // Lista de livros que será observada
    val bookList = repository.getFavoriteBooks().asLiveData()

    /**
     * Atualiza boolean de favorito
     * */
    fun favorite(bookId: Int) {
        viewModelScope.launch {
            // Atualiza boolean de favorito
            repository.toggleFavoriteStatus(bookId)
        }
    }

}