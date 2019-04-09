package IVMaisFuncoes

fun media(vararg notas: Float) {
    var soma = 0F
    for (i in notas) {
        soma += i
    }
    println("Média: ${soma/notas.size}")
}

fun <T> generico(vararg name: T) {
    println("Existem ${name.size} parâmetros!")
}

fun main() {
    media(10F,8F)
}