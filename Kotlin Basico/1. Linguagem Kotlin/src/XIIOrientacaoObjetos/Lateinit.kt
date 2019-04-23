package XIIOrientacaoObjetos

/**
 * Em alguns casos, é necessário que hava um processamento ou uma lógica antes de haver a atribuição do valor a variável
 * Para isso e também evitar declarar a variável como nula, é usado a palavra lateinit.
 * */
class Pessoa7 {
    lateinit var nome: String

    fun geradorDeNome() {
        nome = ""
    }
}

fun main() {

    val p = Pessoa7()
    p.geradorDeNome()

    println(p.nome)

}