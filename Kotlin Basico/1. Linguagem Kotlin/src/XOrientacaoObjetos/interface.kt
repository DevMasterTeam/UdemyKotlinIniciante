package XOrientacaoObjetos

interface Interface1 {
    fun ola() {
        println("Olá interface 1!")
    }
}

interface Interface2 {
    fun ola() {
        println("Olá interface 2!")
    }
}

class implementsInterface : Interface1, Interface2 {
    override fun ola() {
        // Caso queira chamar o super,
        // necessário especificar de qual interface uma vez que possui várias com mesmo método
        super<Interface1>.ola()
    }
}

fun main() {
    val a1 = implementsInterface()
    a1.ola()
}

/**
 * -- Anotações --
 * Interfaces podem conter declarações de métodos abstratos e também métodos com implementação.
 * A diferença de interface com classe abstrata é que interfaces não podem armazenar estados.
 * Ou seja, os atributos da classe não podem ter valores.
 * */