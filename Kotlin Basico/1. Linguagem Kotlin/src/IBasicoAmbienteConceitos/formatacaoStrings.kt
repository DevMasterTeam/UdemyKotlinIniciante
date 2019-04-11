package IBasicoAmbienteConceitos

fun main() {

    val kotlin = "Kotlin " + "é show"
    println(kotlin)

    val nome2 = """Gabriel
        |Ferrari
        |Ceron
    """.trimMargin()

    println("Meu nome é $nome2")
    println("Tamanho do nome: ${nome2.length} caracteres.")

    val linguagem = "Kotlin"
    val caracteristica = "É show!"
    val strFinal = linguagem + " " + caracteristica
    println("$linguagem $caracteristica")

}