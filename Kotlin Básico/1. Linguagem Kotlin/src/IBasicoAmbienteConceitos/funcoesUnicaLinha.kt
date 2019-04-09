package IBasicoAmbienteConceitos

fun soma(a: Int, b: Int): Int {
    return a + b
}

fun primeiraLetra(str: String): Char {
    return str[0]
}

fun soma2(a: Int, b: Int): Int = a + b
fun soma3(a: Int, b: Int) = a + b

fun main() {
    println(soma(2, 2))
    println(soma2(2, 2))
    println(soma3(2, 2))
}

/**
 * -- Anotações --
 * Funções que contém uma única instrução podem ser escritas em uma única linha
 * Funções de única linha não precisam da palavra reservada 'return'
 */