package com.devmasterteam.mybooks.repository

import android.content.ContentValues
import android.content.Context
import com.devmasterteam.mybooks.entity.BookEntity
import com.devmasterteam.mybooks.helper.DataBaseConstants

/**
 * Classe responsável por armazenar e manipular os livros.
 */
class BookRepository private constructor(context: Context) {

    // Acesso ao banco de dados
    private var dataBase: BookDataBaseHelper = BookDataBaseHelper(context)

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
    fun getAllBooks(): List<BookEntity> {

        // Lista de livros
        val books = mutableListOf<BookEntity>()

        // Obtém uma instância de leitura do banco de dados
        val db = dataBase.readableDatabase

        // Query para selecionar todos os livros da tabela
        val cursor = db.query(
            DataBaseConstants.BOOK.TABLE_NAME,  // Nome da tabela
            null,  // Seleciona todas as colunas
            null,  // Sem filtro de linhas
            null,  // Sem argumentos
            null,  // Sem agrupamento
            null,  // Sem filtro de ordenação
            null   // Sem limite
        )

        // Verifica se o cursor contém algum dado e percorre todas as linhas
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.ID))
                val title = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.TITLE))
                val author = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.AUTHOR))
                // Converte de volta para booleano
                val fav = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.FAVORITE)) == 1
                val genre = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.GENRE))

                // Adiciona o livro à lista
                books.add(BookEntity(id, title, author, fav, genre))

                // Continua enquanto houver mais registros
            } while (cursor.moveToNext())
        }

        cursor.close()  // Fecha o cursor após o uso
        db.close()  // Fecha o banco de dados

        return books  // Retorna a lista de livros
    }

    /**
     * Retorna todos os livros marcados como favoritos.
     */
    fun getFavoriteBooks(): List<BookEntity> {
        // Lista de livros
        val favoriteBooks = mutableListOf<BookEntity>()

        // Obtém uma instância de leitura do banco de dados
        val db = dataBase.readableDatabase

        // Query para selecionar todos os livros favoritos
        val cursor = db.query(
            DataBaseConstants.BOOK.TABLE_NAME,  // Nome da tabela
            null,  // Seleciona todas as colunas
            "${DataBaseConstants.BOOK.COLUMNS.FAVORITE} = ?",  // Filtro para favoritos
            arrayOf("1"),  // Argumento para 'favorite = 1'
            null,  // Sem agrupamento
            null,  // Sem filtro de ordenação
            null   // Sem limite
        )

        // Verifica se o cursor contém algum dado e percorre todas as linhas
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.ID))
                val title = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.TITLE))
                val author = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.AUTHOR))
                val fav = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.FAVORITE)) == 1
                val genre = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.GENRE))

                // Adiciona o livro à lista de favoritos
                favoriteBooks.add(BookEntity(id, title, author, fav, genre))

            } while (cursor.moveToNext())
        }

        cursor.close()  // Fecha o cursor após o uso
        db.close()  // Fecha o banco de dados

        return favoriteBooks  // Retorna a lista de livros favoritos
    }

    /**
     * Busca um livro pelo ID.
     */
    fun getBookById(id: Int): BookEntity? {
        // Obtém uma instância de leitura do banco de dados
        val db = dataBase.readableDatabase

        // Query para selecionar um livro pelo ID
        val cursor = db.query(
            DataBaseConstants.BOOK.TABLE_NAME,  // Nome da tabela
            null,  // Seleciona todas as colunas
            "${DataBaseConstants.BOOK.COLUMNS.ID} = ?",  // Filtro para o ID
            arrayOf(id.toString()),  // Argumento para ID
            null,  // Sem agrupamento
            null,  // Sem filtro de ordenação
            null   // Sem limite
        )

        // Verifica se o cursor contém algum dado
        var book: BookEntity? = null
        if (cursor.moveToFirst()) {
            val bookId = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.ID))
            val title = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.TITLE))
            val author = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.AUTHOR))
            val fav = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.FAVORITE)) == 1
            val genre = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.GENRE))

            // Cria o objeto BookEntity
            book = BookEntity(bookId, title, author, fav, genre)
        }

        cursor.close()  // Fecha o cursor após o uso
        db.close()  // Fecha o banco de dados

        return book  // Retorna o livro encontrado ou null
    }

    /**
     * Alterna entre true e false o atributo 'favorite'
     * */
    fun toggleFavoriteStatus(id: Int) {
        // Obtém o livro filtrado pelo ID
        val book = getBookById(id)
        val newFavoriteStatus = if (book?.favorite == true) 0 else 1
        val db = dataBase.writableDatabase

        // Atualiza o status de favorito
        val values = ContentValues().apply {
            put(DataBaseConstants.BOOK.COLUMNS.FAVORITE, newFavoriteStatus)
        }

        db.update(
            DataBaseConstants.BOOK.TABLE_NAME,
            values,
            "${DataBaseConstants.BOOK.COLUMNS.ID} = ?",
            arrayOf(id.toString())
        )

        // Fecha o banco de dados
        db.close()
    }

    /**
     * Remove um livro pelo ID
     * */
    fun deleteBook(id: Int): Boolean {
        // Obtém uma instância de escrita do banco de dados
        val db = dataBase.writableDatabase

        // Deleta o livro pelo ID
        val rowsDeleted = db.delete(
            DataBaseConstants.BOOK.TABLE_NAME,
            "${DataBaseConstants.BOOK.COLUMNS.ID} = ?",
            arrayOf(id.toString())
        )

        // Fecha o banco de dados
        db.close()

        // Retorna true se uma linha foi deletada, caso contrário, false
        return rowsDeleted > 0
    }
}
