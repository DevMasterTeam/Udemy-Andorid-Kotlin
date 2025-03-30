package com.devmasterteam.mybooks.helper

class DataBaseConstants private constructor() {
    object BOOK {
        const val TABLE_NAME = "BookTable"

        object COLUMNS {
            const val ID = "id"
            const val TITLE = "title"
            const val AUTHOR = "author"
            const val FAVORITE = "favorite"
            const val GENRE = "genre"
        }
    }
}