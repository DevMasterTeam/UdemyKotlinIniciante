package VMaisSobreTipos

// Este não é um exemplo de sobrecarga
fun AnyExemplo(value: Any) {
    println(value)
}

fun validacao(value: String): Nothing {
    throw Exception(value)
}

fun main() {
    AnyExemplo(1)
    AnyExemplo("Olá!")
    AnyExemplo(108.0F)
    AnyExemplo(listOf(1, 2))
}

/**
 * -- Anotações --
 * Any
 * Todos objetos em Kotlin herdam de Any, ou seja, Any é um super tipo de todos os outros existentes em Kotlin.
 *
 * Unit
 * Mesmo funcionamento do void no Java. Em funções, significa que não existe retorno, a função simplesmente executa e termina.
 *
 * Nothing
 * Este tipo não existe em Java. Nothing é um tipo somente existente em Kotlin.
 * Diferente de Unit, se usado no retorno de uma função não quer dizer que não retorna nulo, mas sim que não tem retorno algum.
 * Geralmente é usado em funções para retornar erros.
 */