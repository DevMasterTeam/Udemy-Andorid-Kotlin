package com.devmasterteam.mybooks.repository

import android.content.Context
import com.devmasterteam.mybooks.entity.BookEntity

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
     * Massa inicial de dados
     * */
    private fun getInitialBooks(): List<BookEntity> {
        return listOf(
            BookEntity(1, "To Kill a Mockingbird", "Harper Lee", true, "Ficção"),
            BookEntity(2, "Dom Casmurro", "Machado de Assis", false, "Romance"),
            BookEntity(3, "O Hobbit", "J.R.R. Tolkien", true, "Fantasia"),
            BookEntity(4, "Cem Anos de Solidão", "Gabriel García Márquez", false, "Romance"),
            BookEntity(5, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", false, "Fantasia"),
            BookEntity(6, "Crime e Castigo", "Fiódor Dostoiévski", false, "Ficção policial"),
            BookEntity(7, "Frankenstein", "Mary Shelley", false, "Terror"),
            BookEntity(8, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", false, "Fantasia"),
            BookEntity(9, "Neuromancer", "William Gibson", false, "Cyberpunk"),
            BookEntity(10, "Senhor dos Anéis", "J.R.R. Tolkien", false, "Fantasia"),
            BookEntity(11, "Drácula", "Bram Stoker", false, "Terror"),
            BookEntity(12, "Orgulho e Preconceito", "Jane Austen", false, "Romance"),
            BookEntity(13, "Harry Potter e a Câmara Secreta", "J.K. Rowling", false, "Fantasia"),
            BookEntity(14, "As Crônicas de Nárnia", "C.S. Lewis", false, "Fantasia"),
            BookEntity(15, "O Código Da Vinci", "Dan Brown", false, "Mistério"),
            BookEntity(16, "It: A Coisa", "Stephen King", false, "Terror"),
            BookEntity(17, "Moby Dick", "Herman Melville", true, "Aventura"),
            BookEntity(18, "O Nome do Vento", "Patrick Rothfuss", true, "Fantasia"),
            BookEntity(19, "O Conde de Monte Cristo", "Alexandre Dumas", true, "Aventura"),
            BookEntity(20, "Os Miseráveis", "Victor Hugo", false, "Romance")
        )
    }

    /**
     * Faz a criação dos livros no banco de dados
     * */
    fun loadInitialData() {
        dataBase.create(getInitialBooks())
    }

    /**
     * Retorna todos os livros armazenados.
     */
    fun getAllBooks(): List<BookEntity> {
        return dataBase.getAllBooks()
    }

    /**
     * Retorna todos os livros marcados como favoritos.
     */
    fun getFavoriteBooks(): List<BookEntity> {
        return dataBase.getFavoriteBooks()
    }

    /**
     * Busca um livro pelo ID.
     */
    fun getBookById(id: Int): BookEntity {
        return dataBase.getBookById(id)
    }

    /**
     * Alterna entre true e false o atributo 'favorite'
     * */
    fun toggleFavoriteStatus(id: Int) {
        val book = getBookById(id)
        book.favorite = !book.favorite
        dataBase.update(book)
    }

    /**
     * Remove um livro pelo ID
     * */
    fun deleteBook(id: Int): Boolean {
        return dataBase.delete(getBookById(id)) > 0
    }
}
