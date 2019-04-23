package XIIOrientacaoObjetos

/**
 * Uma classe sem atributos ou funções, pode ser declarada sem chaves.
 * */
class Pessoa1

/**
 * Os mesmos conceitos de var e val se aplicam as classes.
 * Atributos que uma vez são atribuídos valor e não mudam podem ser declarados como val.
 * Atributos cujo valor muda constantemente devem ser declarados como var
 * Da mesma maneira, se não há 'corpo' para uma classe (atributos ou funções), não há necessidade de chaves.
 * */
class Pessoa2(var nome: String, val anoNascimento: Int)

/**
 * Aqui, a estrutura de uma classe com atributos e métodos.
 * Nesse exemplo temos um novo atributo fome e também há a possibilidade de atribuir um valor padrão (default).
 * */
class Pessoa3(var nome: String, val anoNascimento: Int, val fome: Boolean = false) {
    fun saudacao() {
        println("Meu nome é $nome")
    }
}