package XOrientacaoObjetos

// Classe com construtor privado impedindo que seja instanciada
class DatabaseConstants private constructor() {
    companion object GUEST {
        val TABLE_NAME = "Guest"

        object COLUMNS {
            val id = "id"
            val name = "name"
        }
    }
}

fun main() {
    DatabaseConstants.GUEST.TABLE_NAME
    DatabaseConstants.GUEST.COLUMNS.id
}