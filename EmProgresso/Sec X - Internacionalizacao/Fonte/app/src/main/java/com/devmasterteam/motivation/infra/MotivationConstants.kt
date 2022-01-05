package com.devmasterteam.motivation.infra

/**
 * Chaves usadas pela aplicação
 * Definir em variáveis para remover o risco de digitar incorretamente
 * */
class MotivationConstants private constructor() {

    object KEY {
        val PERSON_NAME = "personName"
    }

    object PHRASEFILTER {
        val ALL = 0
        val HAPPY = 1
        val MORNING = 2
    }

    object LANGUAGE {
        val English = "en"
        val Portuguese = "pt"
        val French = "fr"
    }

}