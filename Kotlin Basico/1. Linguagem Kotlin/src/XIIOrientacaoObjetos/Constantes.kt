package XIIOrientacaoObjetos

/**
 * Só pode haver um companion object dentro da classe.
 * No entanto, pode haver N objects dentro de uma classe, porém companion não precisa necessariamente ter um nome,
 * enquanto object precisa.
 * */

// Classe com construtor privado impedindo que seja instanciada
class DatabaseConstants private constructor() {
    companion object GUEST {
        val TABLE_NAME = "Guest"

        object COLUMNS {
            val id = "id"
        }
    }

    object SELL {
        object COLUMNS {
            val total = "total"
        }
    }
}

fun main() {
    DatabaseConstants.GUEST.TABLE_NAME
    DatabaseConstants.GUEST.COLUMNS.id
    DatabaseConstants.SELL.COLUMNS.total
}