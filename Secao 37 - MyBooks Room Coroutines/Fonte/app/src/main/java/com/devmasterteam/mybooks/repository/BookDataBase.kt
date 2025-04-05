package com.devmasterteam.mybooks.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.devmasterteam.mybooks.entity.BookEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [BookEntity::class], version = 1)
abstract class BookDataBase : RoomDatabase() {

    // Data Access Object
    abstract fun bookDAO(): BookDAO

    companion object {

        // Nome do banco de dados
        private const val DATABASE_NAME = "books_db"

        // Padrão Singleton
        private lateinit var instance: BookDataBase

        // Padrão Singleton
        fun getDatabase(context: Context): BookDataBase {
            if (!::instance.isInitialized) {
                synchronized(this) {
                    instance =
                        Room.databaseBuilder(context, BookDataBase::class.java, DATABASE_NAME)
                            .addMigrations(Migrations.migrationFromV1ToV2)

                            // Consultas na thread principal (main thread) podem bloquear a interface
                            // Para evitar isso, é necessário consultas assíncronas
                            //.allowMainThreadQueries()

                            // Callback para responder após a criação das tabelas do banco de dados
                            .addCallback(DatabaseCallback())

                            .build()
                }
            }
            return instance
        }
    }

    private class DatabaseCallback : Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            CoroutineScope(Dispatchers.IO).launch {
                instance.bookDAO().create(getInitialBooks())
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
                BookEntity(
                    8,
                    "Harry Potter e a Pedra Filosofal",
                    "J.K. Rowling",
                    false,
                    "Fantasia"
                ),
                BookEntity(9, "Neuromancer", "William Gibson", false, "Cyberpunk"),
                BookEntity(10, "Senhor dos Anéis", "J.R.R. Tolkien", false, "Fantasia"),
                BookEntity(11, "Drácula", "Bram Stoker", false, "Terror"),
                BookEntity(12, "Orgulho e Preconceito", "Jane Austen", false, "Romance"),
                BookEntity(
                    13,
                    "Harry Potter e a Câmara Secreta",
                    "J.K. Rowling",
                    false,
                    "Fantasia"
                ),
                BookEntity(14, "As Crônicas de Nárnia", "C.S. Lewis", false, "Fantasia"),
                BookEntity(15, "O Código Da Vinci", "Dan Brown", false, "Mistério"),
                BookEntity(16, "It: A Coisa", "Stephen King", false, "Terror"),
                BookEntity(17, "Moby Dick", "Herman Melville", true, "Aventura"),
                BookEntity(18, "O Nome do Vento", "Patrick Rothfuss", true, "Fantasia"),
                BookEntity(19, "O Conde de Monte Cristo", "Alexandre Dumas", true, "Aventura"),
                BookEntity(20, "Os Miseráveis", "Victor Hugo", false, "Romance")
            )
        }
    }

    // Migrações
    private object Migrations {
        /**
         * Atualização de versão de banco de dados
         */
        val migrationFromV1ToV2: Migration = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // Limpar o banco de dados
                db.execSQL("DELETE FROM Book")

                // Criar uma nova coluna, atualizar valores, etc etc
                // Qualquer tipo de lógica de banco de dados para garantir a atualização de versão
            }
        }
    }

}