package XOrientacaoObjetos

/**
 * Classe abstrata não pode ser instanciada
 * Define alguns comportamentos que as classe que herdam devem ter
 */
abstract class Mamifero(nome: String, var idade: Int) {
    abstract fun talk()
}

/**
 * Herda de mamífero
 * */
class Cachorro(nome: String, idade: Int) : Mamifero(nome, idade) {
    override fun talk() {
        println("Au au")
    }
}

fun main() {
    Cachorro("Bolt", 8).talk()
}

/**
 * -- Anotações --
 * Classe abstrata não pode ser instanciada
 * Pode definir alguns comportamentos por padrão e outros métodos que são obrigatórios que sejam reescritos.
 * Se houver ao menos um método abstrato, a classe deve ser abstrata
 * */