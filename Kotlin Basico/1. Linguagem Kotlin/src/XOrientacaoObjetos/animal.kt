package XOrientacaoObjetos

import java.lang.Exception

class Animal(var nome: String, var fome: Boolean = false) {

    var sono = false
        set(value) {
            if (!value) {
                println("Você não pode deixar o animal acordado.")
            }
            field = value
        }
        get() {
            return field
        }

    fun comer() {
        fome = false
    }

    fun dormir() {
        fome = true
    }
}

fun main() {

    val animal = Animal("Mimosa", false)
    animal.sono = false

    animal.comer()
    animal.comer()
    animal.comer()
    animal.dormir()

}

fun digaMeuNome (nome: String) : String {
    return "Hey $nome"
}
