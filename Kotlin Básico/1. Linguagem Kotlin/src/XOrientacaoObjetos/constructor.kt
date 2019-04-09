package XOrientacaoObjetos

class ClassePrivada private constructor()

class Pessoa(val nome: String) {
    constructor(n1: String, idade: Int) : this(n1)
    constructor(n1: String, idade: Int, signo: String) : this(n1)
}

fun main(args: Array<String>) {

    val c1 = Pessoa("Gabriel")
    val c2 = Pessoa("Gabriel", 26)
    val c3 = Pessoa("Gabriel", 26, "Gêmeos")

    println(c1)
    println(c2)
    println(c3)

}