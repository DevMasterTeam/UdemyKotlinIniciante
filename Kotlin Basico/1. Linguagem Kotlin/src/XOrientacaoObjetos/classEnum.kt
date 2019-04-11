package XOrientacaoObjetos

enum class Priority(val id: Int) {
    LOW(1) {
        override fun toString(): String {
            return "Essa é única!"
        }
    },
    MEDIUM(5), HIGH(10), CRITICAL(20);

    override fun toString(): String {
        return "$name é da posição $ordinal e id: $id"
    }

    fun teste() {}
}

fun main() {

    // Podemos chamar uma função disponível para todos os enum
    Priority.CRITICAL.teste()

    // Para cada uma das prioridades
    for (p in Priority.values()) {
        if (p == Priority.CRITICAL) {
            println("Isso é muito importante!")
        } else {
            println(p)
        }
    }
}