package XIIOrientacaoObjetos

/**
 * Data class geralmente são classes usadas para transitar dados.
 * Possuem implementação de toString() para um formato legível, implementam o método copy, hashCode e equals.
 *
 * Essas são as diferenças trazidas junto com o uso da palavra 'data'.
 * O comportamento do método toString() facilita a leitura de dados quando necessário.
 * Além disso, caso haja necessiadde do método hasCode e copy, já estão implementados.
 *
 * Regras para usar data class
 * 1. Precisam ter ao menos um atributo no construtor primário como var ou val
 * 2. Não podem ser abstratas
 * */

class Quadrado (val area: Float)

data class Triangulo (val area: Float)

fun main() {

    val q1 = Quadrado(10f)
    val q2 = Quadrado(10f)

    val t1 = Triangulo(10f)
    val t2 = Triangulo(10f)

    // Ao imprimir a instância da classe, há a facilidade com uso do data class
    println(q1.toString())
    println(t1.toString())
    println("----------")

    // Ao fazer a comparação, o método equals é chamado.
    // Porém, ao fazer essa comparação com class, o que é comparado de fato é o endereço da instância na memória.
    // Ao usar data class, o que é comparado de fato são os valores dos atributos
    println(q1 == q2)
    println(t1 == t2)
    println("----------")

    // Data class considera o valor dos atributos, dessa maneira, valores gerados são iguais.
    println("${q1.hashCode()} - ${q2.hashCode()}")
    println("${t1.hashCode()} - ${t2.hashCode()}")
    println("----------")

    // Class não possui o método copy por padrão
    // q1.copy()

    // Data class tem o método copy por padrão
    t1.copy(area = 45f)
}