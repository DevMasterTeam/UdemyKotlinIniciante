package com.devmasterteam.motivation.infra

/**
 * Chaves usadas pela aplicação
 * Definir em variáveis para reduzir o risco de digitar incorretamente
 * */
class MotivationConstants private constructor() {

    object KEY {
        val PERSON_NAME = "personName"
    }

    object PHRASE_FILTER {
        val ALL = 0
        val HAPPY = 1
        val MORNING = 2
    }

}