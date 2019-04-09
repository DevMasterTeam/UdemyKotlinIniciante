package IBasicoAmbienteConceitos

fun helloWorld() {
    println("Olá Mundo!")
}

fun meuNome(nome: String) {
    println("Olá $nome!")
}

fun meuNomeIdade(nome: String, idade: Short) {
    println("Olá $nome! Tenho $idade anos.")
}

fun letraIndice(nome: String, indice: Int): Char {
    return nome[indice]
}

fun main() {
    helloWorld()
    meuNome("Gabriel")
    meuNomeIdade("Gabriel", 27)
    letraIndice("Gabriel", 0)

    var str1 = "Visitante"
    var str2 = "Olá #{str1}"

}

/**
 * -- Anotações --
 * Quando não existe um tipo declarado para o retorno da função, considera-se do tipo Unit
 */