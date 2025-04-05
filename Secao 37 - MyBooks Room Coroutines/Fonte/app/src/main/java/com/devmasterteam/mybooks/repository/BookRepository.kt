package com.devmasterteam.mybooks.repository

import android.content.Context
import androidx.lifecycle.asFlow
import com.devmasterteam.mybooks.entity.BookEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

/**
 * Classe responsável por armazenar e manipular os livros.
 */
class BookRepository private constructor(context: Context) {

    // Acesso ao banco de dados
    private val dataBase = BookDataBase.getDatabase(context).bookDAO()

    /**
     * O padrão Singleton garante que uma classe tenha apenas uma instância durante toda a execução do programa.
     * Ele fornece um ponto de acesso global para acessar essa instância de forma controlada e segura.
     *
     * Vantagens do Singleton:
     * - Garante que a classe tenha uma única instância.
     * - Oferece um ponto de acesso global para essa instância.
     * - Pode ser útil para recursos compartilhados, como conexões de banco de dados ou repositórios de dados.
     */
    companion object {
        private lateinit var instance: BookRepository

        /**
         * Fornece a única instância do BookRepository.
         * Esta é uma implementação thread-safe do padrão singleton.
         */
        fun getInstance(context: Context): BookRepository {
            synchronized(this) {
                if (!::instance.isInitialized) {
                    instance = BookRepository(context)
                }
            }
            return instance
        }
    }

    /**
     * Retorna todos os livros armazenados.
     */
    fun getAllBooks(): Flow<List<BookEntity>> {
        return dataBase.getAllBooks()
    }

    /**
     * Retorna todos os livros marcados como favoritos.
     */
    fun getFavoriteBooks(): Flow<List<BookEntity>> {
        return dataBase.getFavoriteBooks()
    }

    /**
     * Busca um livro pelo ID.
     */
    suspend fun getBookById(id: Int): BookEntity {
        return dataBase.getBookById(id)
    }

    /**
     * Alterna entre true e false o atributo 'favorite'
     * */
    suspend fun toggleFavoriteStatus(id: Int) {
        val book = getBookById(id)
        book.favorite = !book.favorite
        dataBase.update(book)
    }

    /**
     * Remove um livro pelo ID
     * */
    suspend fun deleteBook(id: Int): Boolean {
        return dataBase.delete(getBookById(id)) > 0
    }
}
