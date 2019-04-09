package XOrientacaoObjetos

class Quadrado (val area: Int)

data class Triangulo (val area: Int)

fun main() {

    val q1 = Quadrado(10)
    val q2 = Quadrado(10)

    val t1 = Triangulo(10)
    val t2 = Triangulo(10)

    println(q1.toString())
    println(t1.toString())
    println("----------")

    println(q1.equals(q2))
    println(t1.equals(t2))
    println("----------")

    println("${q1.hashCode()} - ${q2.hashCode()}")
    println("${t1.hashCode()} - ${t2.hashCode()}")
    println("----------")

    // q1.copy()
    t1.copy(area = 45)
}

/**
 * -- Anotações --
 * Data class geralmente são classes usadas para transitar dados.
 * Possuem implementação de toString() para um formato legível,
 * implementam o método copy e hashCode.
 *
 * No final das contas, não existe um motivo extremamente motivador para o uso de data classes,
 * mas elas trazem alguns comportamentos implementados por padrão e facilitam a leitura de dados quando
 * impressas usando toString()
 *
 * Regras para usar data class
 * 1. Precisam ter ao menos um atributo no construtor primário
 * 2. Não podem ser abstratas
 * */