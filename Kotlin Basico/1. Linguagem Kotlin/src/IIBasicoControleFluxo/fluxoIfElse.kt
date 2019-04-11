package IIBasicoControleFluxo

fun maiorDeIdade(idade: Int): String {
    return if (idade >= 18) {
        "Maior de idade."
    } else {
        "Menor de idade."
    }
}

fun maiorDeIdadeLinha(idade: Int): String = if (idade >= 18) "Maior de idade." else "Menor de idade."

fun bonusFuncionario(anosEmpresa: Int) {
    if (anosEmpresa >= 0) {
        println("Bônus padrão: R$200,00")
    } else {
        if (anosEmpresa >= 1 && anosEmpresa < 3) {
            println("Bônus: R$400,00")
        } else if (anosEmpresa >= 3 && anosEmpresa < 5) {
            println("Bônus: R$100,00")
        } else {
            println("Bônus: R$2000,00")
        }
    }
}

fun main() {
    println(maiorDeIdade(15))
    println(maiorDeIdade(26))

    bonusFuncionario(1)
    bonusFuncionario(2)
    bonusFuncionario(3)
    bonusFuncionario(4)
    bonusFuncionario(5)

    // Operador Elvis
    val str : String? = null
    val verif = if (str == null) "NULO" else str
    val verif2 = str ?: "NULO"
}

/**
 * -- Anotações --
 * Diferente de grande parte das linguagens atuais, if else é uma expressão em Kotlin
 * Sendo uma expressão, ela é capaz de retornar valor.
 *
 * Operador ternário
 * Não existe operador ternário em Kotlin, pois if else substituem a funcionalidade
 *
 * Operador Elvis
 * Precisa de uma varíavel que pode ser nula para fazer a verificação.
 * É uma variante do operador ternário, pois não permite fazer a verificar de um valor e escolher entre outros dois.
 * Ele diz, caso a variável seja diferente de nulo, use-a, caso contrário, use a outra expressão.
 */