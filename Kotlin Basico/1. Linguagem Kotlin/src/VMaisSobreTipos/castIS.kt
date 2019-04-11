package VMaisSobreTipos

fun qualquerTipo(value: Any) {
    if (value is Int) {
    } else if (value is String) {
    } else if (value is Juridica) {
    } else if (value is Fisica) {
    }
}

fun whenExemplo(x: Any) {
    when (x) {
        is Int -> print(x + 1)
        is String -> print(x.length + 1)
        is IntArray -> print(x.sum())
    }
}

open class Pessoa
class Juridica : Pessoa()
class Fisica : Pessoa()

fun main() {

    val p1: Pessoa = Juridica()
    val p2: Pessoa = Fisica()

}