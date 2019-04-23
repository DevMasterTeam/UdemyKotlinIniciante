package XIIOrientacaoObjetos

/**
 * Um construtor é um método chamado no momento que uma classe é instanciada.
 * É muito comum que no construtor haja a atribuição de valores para os atributos da classe.
 *
 * Nesse exemplo existe um construtor primário e dois secundários.
 * Existem alguns detalhes nos contrutores secundários que devem ser observados.
 * 1. Atributos não podem ser val nem var, devem somente ter o nome do atributo e o tipo.
 * 2. Não podem ser acessados dentro ou fora da classe.
 * Para que seja possível, atributos dentro da classe devem ser declarados.
 * */
class Pessoa4(val nome: String) {

    // Atributo dentro da classe que o construtor secundário fará a atribuição
    // Em casos desse tipo, é importante prestar atenção que a variável pode ser nula
    // caso seja iniciada pelo construtor primário.
    var idade: Int? = null

    // Construtor secundário
    constructor(n1: String, idade: Int) : this(n1) {
        this.idade = idade
    }

    // Função
    fun saudacoes() {
        println("Meu nome é $nome e tenho $idade")
    }

}

/**
 * Em casos em que a classe não deve ser instanciada, é possível tornar o construtor privado.
 * */
class PessoaPrivada private constructor()


fun main() {

    val p1 = Pessoa4("Gabriel")
    println(p1.idade)

    val p2 = Pessoa4("Gabriel", 20)
    println(p2.idade)

}