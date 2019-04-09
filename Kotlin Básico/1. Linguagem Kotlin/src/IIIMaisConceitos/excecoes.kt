package IIIMaisConceitos

fun main() {
    try {
        // Sem problemas
        val number = "1".toInt()
        println(number)

        // Vai acontecer o erro
        val notANumber = "aa".toInt()
        println("Não vai chegar nem a imprimir")

    } catch (e: NumberFormatException) {
        println("Erro na conversão de número!")
    } catch (e: Exception) {
        println("Não sei o que aconteceu!!")
    } finally {
        // Código sempre executado
        println("Finalmente!")
    }

}