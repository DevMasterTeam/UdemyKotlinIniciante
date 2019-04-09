package IVMaisFuncoes

fun endereco(rua: String, cidade: String = "", estado: String, cep: String = "") {
    println("Rua: $rua")
    println("Cidade: $cidade, $estado - $cep")
}

fun main() {
    endereco("Rua Kotlin", cep = "18887-854", estado = "São Paulo")
}