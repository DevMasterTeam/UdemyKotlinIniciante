package XOrientacaoObjetos

fun helpPrint() {
    println("Overload")
}

fun helpPrint (value: Int) {
    println("Overload")
}

class Produto {
    override fun toString(): String {
        return "Produto sem atributo algum."
    }
}

fun main() {
    val p = Produto()
    println(p.toString())
}