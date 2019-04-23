package com.devmasterteam.componentes

/**
 * Classe de fornecimento de dados
 * Construtor privado impede que a classe seja instanciada e acesso aos dados se dá através do método spinnerMock.
 * */
class Mock private constructor() {

    companion object {

        /**
         * Retorna lista de strings para spinner
         */
        fun spinnerMock(): List<String> = listOf("Gramas", "Kg", "Arroba", "Tonelada")

    }

}