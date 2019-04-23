package XIIOrientacaoObjetos

/**
 * Herança é uma funcionalidade em orientação a objetos que permite fazer a especialização de classes.
 * A classe Maquina é a classe pai de Computador.
 * A classe Computador é a especialização de Maquina, possuindo um atributo a mais.
 * Também é possível ter mais funções.
 *
 * Para que uma classe possa ser herdada, é necessário o uso da palavra 'open'.
 * */

// Classe base
open class Maquina (val marca: String) {
    fun minhaMarca() {
        println("Sou da marca: $marca")
    }

    private fun somenteMaquina() {
        println("Esse método é acessível somente por instâncias da classe Maquina.")
    }
}

// Classe especializada
class Computador (marca: String, val nucleos: Short) : Maquina(marca)


fun main() {

    val comp = Computador("DELL", 4)
    comp.minhaMarca()
    comp.nucleos

    // Não acessível
    // comp.somenteMaquina()

}