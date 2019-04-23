package XIIOrientacaoObjetos

/**
 * Interfaces podem conter declarações de métodos que serão sobrescritos e também métodos com implementação.
 * Os métodos que serão sobrescritos precisam estar com assinatura e tipo de retorno definido,
 * não há necessidade de haver corpo.
 *
 * A diferença de interface com classe abstrata é que interfaces não podem armazenar estados.
 * Ou seja, os atributos da classe não podem ter valores.
 * */
interface Interface1 {
    fun teste()
    fun ola() {
        println("Olá interface 1!")
    }
}

interface Interface2 {
    fun ola() {
        println("Olá interface 2!")
    }
}

class ImplementsInterface : Interface1, Interface2 {
    override fun teste() {
        println("Sobrescrita")
    }

    override fun ola() {
        // Necessário especificar de qual interface, uma vez que possui várias com mesmo método
        super<Interface1>.ola()
    }
}

fun main() {
    val a1 = ImplementsInterface()
    a1.ola()
}