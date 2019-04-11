package IBasicoAmbienteConceitos

fun main() {

    // Variáveis capaz de armazenar um cadeia de caracters
    var nome = "Gabriel Ferrari"

    // Números
    var idade = 15
    var distancia = 450
    var cotacaoMoeda = 4.5f

    // Binários - True ou False
    var ligado = false

    // ---------------------------
    // Uso das variáveis com tipos

    // Imutável
    val nomeFinal = "Gabriel Ferrari"

    // Mutável quantas vezes desejar
    var litros: Int = 2

    // Ao fazer a criação de uma variável sem tipo (número) - Atenção ao tipo que será usado
    val idadeSemTipo = 27

    // Imutável uma vez atribuída
    val sobreNome: String
    nome = "Augustos"

}

/**
 * -- Anotações --
 * Kotlin sempre sugere que seja feito o uso de variáveis 'val' ao invés de 'var'
 * 1. Ao usar uma variável 'val' que não tenha sido atribuída, acontece erro de compilação
 * 2. É mais fácil saber qual o valor da variável
 */