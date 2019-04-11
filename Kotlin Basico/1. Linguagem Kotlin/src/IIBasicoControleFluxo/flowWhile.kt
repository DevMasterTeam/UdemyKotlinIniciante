package IIBasicoControleFluxo

fun main() {
    var indice = 1
    while (indice < 10){
        print("$indice ")
        indice++
    }

    println()
    println("-------------")

    var indiceDoWhile = 1
    do {
        print("$indiceDoWhile ")
        indiceDoWhile++
    } while (indiceDoWhile < 0)
}