package XOrientacaoObjetos

open class Maquina (val marca: String) {
    open fun minhaMarca() {
        println("Sou da marca: $marca")
    }
}

class Computador (marca: String, val nucleos: Short) : Maquina(marca) {

    override fun minhaMarca() {
        println("Não tenho")
    }

    fun nucleos() {
        println("Eu tenho $nucleos núcleos.")
    }
}

fun main() {

    Maquina("EscaveX").minhaMarca()
    Computador("DELL", 8).minhaMarca()

}