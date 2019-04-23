package XIIIColecoes

/**
 * Set
 * Assim como listas, podem ser mutáveis ou imutáveis.
 *
 * A coleção Set não permite elementos duplicados, o que é uma característica muito útil.
 * Caso dois valores sejam adicionados no Set, somente um deles será usado e não acontecerá erro.
 * */
fun main() {

    // Criação de Set com String e Int. Aceita qualquer tipo de dado.
    val set = setOf("Madrid", "São Paulo", "Berlim")
    val s11: Set<Int> = setOf(1)

    // Cria um set mutável com elementos repetidos
    val setMutavel = mutableSetOf(1, 2, 3, 4, 5, 5, 5, 5, 5, 5)

    // Imprime o set com elementos repetidos
    println(setMutavel)

    // Adicionando mais elementos repeitidos e imprimindo novamente
    setMutavel.add(5)
    setMutavel.add(5)
    setMutavel.add(5)
    setMutavel.add(5)

    // Elementos únicos - não repetidos
    println(setMutavel)
}