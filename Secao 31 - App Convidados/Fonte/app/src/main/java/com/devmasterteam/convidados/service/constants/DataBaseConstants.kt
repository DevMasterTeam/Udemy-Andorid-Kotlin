package com.devmasterteam.convidados.service.constants

/**
 * Todas as constantes utilizadas no banco de dados - Tabelas e colunas
 */
class DataBaseConstants private constructor() {

    /**
     * Tabelas disponíveis no banco de dados com suas colunas
     */
    object GUEST {
        const val ID = "guestid"
        const val TABLE_NAME = "Guest"

        object COLUMNS {
            const val ID = "id"
            const val NAME = "name"
            const val PRESENCE = "presence"
        }
    }
}