package IIIMaisConceitos

fun ex1(valor: Long) = println(valor)

fun main() {

    val number: Int = 10
    val longNumber: Long = 100

    // ex1(number)

    // Criação de variável Int e conversão explícita
    var n1: Int
    n1 = longNumber.toInt()
    println(longNumber.toString())

    // Conversão de String para Int
    val strNumber = "10"
    n1 = strNumber.toInt()

    println("Meu número é: $n1")

    // ERRO -  Não é possível converter String com letras para Int
    "ajgf".toInt()

}