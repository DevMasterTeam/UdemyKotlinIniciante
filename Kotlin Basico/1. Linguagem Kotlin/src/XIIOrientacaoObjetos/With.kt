package XIIOrientacaoObjetos

fun main() {
    val str = "Curso de Kotlin!!"

    str.capitalize()
    str.toUpperCase()
    str.decapitalize()
    str.toLowerCase()

    // Faz o uso da instância da classe para chamar diversos métodos
    with(str) {
        capitalize()
        toUpperCase()
        decapitalize()
        toLowerCase()
    }
}