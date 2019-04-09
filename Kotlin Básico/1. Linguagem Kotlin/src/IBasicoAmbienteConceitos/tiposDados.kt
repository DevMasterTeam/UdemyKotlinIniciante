package IBasicoAmbienteConceitos

/**
Type	Bit
Double	64
Float	32
Long	64
Int	    32
Short	16
Byte	8
Boolean ?
String  ?
Char    ?
*/

/** Lembrando sobre unidades de medida
1 Byte = 8 bits
1 kilobyte (kB) = 1024 bytes
1 megabyte (MB) = 1024 kilobytes
1 gigabyte (GB) = 1024 megabytes
*/

fun main() {

    println("Double: Max: " + Double.MAX_VALUE + " - Double: " + Double.MIN_VALUE)
    println("Float: Max: " + Float.MAX_VALUE + " - Min: " + Float.MIN_VALUE)
    println("Long: Max: " + Long.MAX_VALUE + " - Long: " + Long.MIN_VALUE)
    println("Int: Max: " + Int.MAX_VALUE + " - Min: " + Int.MIN_VALUE)
    println("Short: Max: " + Short.MAX_VALUE + " - Min: " + Short.MIN_VALUE)
    println("Byte: Max: " + Byte.MAX_VALUE + " - Min: " + Byte.MIN_VALUE)

}

/**
 * -- Anotações --
 * O tamanho Boolean pode ser representado somente com 1 bit, true ou false
 * Porém o tamanho é depende da JVM e a especificaçacão não deixa claro
 *
 * String
 * O tamanho de uma String depende de seu conteúdo.
 *
 * Char
 * O tamanho de um char, assim como Boolean, também é variável e dependente da JVM
 *
 * Fonte
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
 */