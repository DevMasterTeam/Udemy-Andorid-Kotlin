package com.devmasterteam.mybooks.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devmasterteam.mybooks.entity.BookEntity
import com.devmasterteam.mybooks.repository.BookRepository

class FavoriteViewModel : ViewModel() {

    // Acesso a dados
    private val repository = BookRepository.getInstance()

    private val _bookList = MutableLiveData<List<BookEntity>>()
    val bookList: LiveData<List<BookEntity>> = _bookList

    /**
     * Busca livros favoritos
     * */
    fun getFavorites() {
        _bookList.value = repository.getFavoriteBooks()
    }

    /**
     * Atualiza boolean de favorito
     * */
    fun favorite(bookId: Int) {
        // Atualiza boolean de favorito
        repository.toggleFavoriteStatus(bookId)

        // Atualiza listagem para refletir as mudanças
        getFavorites()
    }

}