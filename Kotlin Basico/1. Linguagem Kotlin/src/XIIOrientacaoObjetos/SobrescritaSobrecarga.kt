package XIIOrientacaoObjetos

/**
 * Override
 * Capacidade de um método da classe pai de ser sobrescrito.
 * Da mesma maneira, para que um método possa ser sobrescrito é necessário a palavra fun.
 *
 * Overload
 * Um método com mesmo nome, porém com tipos de dados ou quantidades diferentes.
 * Em outras palavras, a assinatura do método é diferente.
 * Assinatura -> nome, tipo e quantidade de parâmetros.
 * */

// Classe base
open class Maquina2(val marca: String) {
    open fun minhaMarca() {
        println("Sou da marca: $marca")
    }

    private fun somenteMaquina() {
        println("Esse método é acessível somente por instâncias da classe Maquina.")
    }
}

// Classe especializada
class Computador2(marca: String, val nucleos: Short) : Maquina2(marca) {

    override fun minhaMarca() {
        println("Minha marca é $marca e tenho $nucleos núcleos.")
    }

    fun overload(a: String) = println("Overload 1")

    fun overload(a: Int) = println("Overload 2")

    fun overload(a: Int, b: Int) = println("Overload 3")

}


fun main() {

    val comp = Computador2("DELL", 4)
    comp.minhaMarca()
    comp.nucleos

    // Não acessível
    // comp.somenteMaquina()

    // Kotlin sabe qual das funções chamar, já que as assinaturas são diferentes.
    comp.overload("1")
    comp.overload(1)
    comp.overload(1, 2)

}