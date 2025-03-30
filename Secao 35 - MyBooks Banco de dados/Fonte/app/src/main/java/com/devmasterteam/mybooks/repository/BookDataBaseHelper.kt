package com.devmasterteam.mybooks.repository

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.devmasterteam.mybooks.entity.BookEntity
import com.devmasterteam.mybooks.helper.DataBaseConstants

class BookDataBaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    /**
     * Método executado somente uma vez quando o acesso ao banco de dados é feito pela primeira vez
     */
    override fun onCreate(db: SQLiteDatabase) {
        // Executa a criação da tabela no banco
        db.execSQL(CREATE_TABLE_BOOKS)

        // Uma vez criada, executa a inserção da massa de dados
        insertBooks(db)
    }

    /**
     * Método executado quando a versão do DATABASE_VERSION é alterada
     * Dessa maneira, a aplicação sabe que o banco de dados foi alterado e é necessário rodar o script de update
     */
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Deleta a tabela e cria novamente (uma maneira de lidar com atualizações)
        db.execSQL("DROP TABLE IF EXISTS ${DataBaseConstants.BOOK.TABLE_NAME}")
        // Cria novamente usando o novo schema
        onCreate(db)
    }

    /**
     * Função para inserir livros no banco de dados
     */
    private fun insertBooks(db: SQLiteDatabase) {
        val books = getInitialBooks()
        for (book in books) {
            val values = ContentValues().apply {
                put(DataBaseConstants.BOOK.COLUMNS.TITLE, book.title)
                put(DataBaseConstants.BOOK.COLUMNS.AUTHOR, book.author)
                // Converte boolean para inteiro
                put(DataBaseConstants.BOOK.COLUMNS.FAVORITE, if (book.favorite) 1 else 0)
                put(DataBaseConstants.BOOK.COLUMNS.GENRE, book.genre)
            }

            // Insere o livro na tabela
            db.insert(DataBaseConstants.BOOK.TABLE_NAME, null, values)
        }
    }

    /**
     * Cria uma lista inicial de livros para popular o repositório.
     */
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

    // Database name and version
    companion object {
        private const val DATABASE_NAME = "books_db"
        private const val DATABASE_VERSION = 1

        // SQL query to create the table using the constants from the BOOK object
        private const val CREATE_TABLE_BOOKS = """
            CREATE TABLE ${DataBaseConstants.BOOK.TABLE_NAME} (
                ${DataBaseConstants.BOOK.COLUMNS.ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${DataBaseConstants.BOOK.COLUMNS.TITLE} TEXT NOT NULL,
                ${DataBaseConstants.BOOK.COLUMNS.AUTHOR} TEXT NOT NULL,
                ${DataBaseConstants.BOOK.COLUMNS.FAVORITE} INTEGER NOT NULL,
                ${DataBaseConstants.BOOK.COLUMNS.GENRE} TEXT NOT NULL
            );
        """
    }
}