package XOrientacaoObjetos

class Ventilador {
    var nome: String? = null
}

fun main() {

    val v: Ventilador = Ventilador()

    // Erro
    // println(p.nome.length)
    println(v.nome?.length)

}