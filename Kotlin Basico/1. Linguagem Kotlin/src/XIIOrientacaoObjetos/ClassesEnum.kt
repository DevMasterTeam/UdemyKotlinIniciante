package XIIOrientacaoObjetos


enum class Prioridade1 {
    BAIXA, MEDIA, ALTA
}

enum class Prioridade2(val id: Int) {
    BAIXA(1), MEDIA(3), ALTA(10)
}

enum class Prioridade3 {
    BAIXA {
        override fun toString(): String {
            return "Essa é única!"
        }
    },
    MEDIA, ALTA;

    override fun toString(): String {
        return "$name é da posição $ordinal"
    }
}

fun main() {

    // Imprime strings
    println("${Prioridade1.BAIXA} - ${Prioridade1.MEDIA} - ${Prioridade1.ALTA}")
    println("${Prioridade2.BAIXA} - ${Prioridade2.MEDIA} - ${Prioridade2.ALTA}")

    // Imprime os valores
    println("${Prioridade2.BAIXA.id} - ${Prioridade2.MEDIA.id} - ${Prioridade2.ALTA.id}")

    // Para cada uma das prioridades
    for (p in Prioridade3.values()) {
        if (p == Prioridade3.ALTA) {
            println("Isso é muito importante!")
        } else {
            println(p)
        }
    }
}