package XIIOrientacaoObjetos

/**
 * Por trás dos panos, kotlin cria getter e setter para as variáveis da classe.
 * Faça a chamada a classe Pessoa5 a partir de um arquivo Java.
 * */
class Pessoa5(var idade: Int)

fun main() {

    // Ao fazer uma chamada de uma classe Java, só existe getter e setter caso definido explicitamente.
    val javaClass = GetSetJava()
    println(javaClass.idade)

}