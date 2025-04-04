package com.devmasterteam.mybooks.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.devmasterteam.mybooks.entity.BookEntity

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
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return instance
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