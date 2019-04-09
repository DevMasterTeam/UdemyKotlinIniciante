package XIColecoes

fun main() {
    val l1 = listOf(1, 2, 3, 4, 5, 6, 6)
    var l11: List<Int> = listOf(1, 2)

    val l2 = mutableListOf(1, 2, 3, 4, 5, 6, 6)
    var l22: MutableList<Int> = mutableListOf(1, 2)

    val s1 = setOf("Madrid", "São Paulo", "Berlim", "Berlim")
    val s11: Set<String> = setOf("")

    val s2 = mutableSetOf("Madrid", "São Paulo", "Berlim", "Berlim")
    val s22: MutableSet<String> = mutableSetOf("")

    val h1 = hashMapOf(Pair("França", "Paris"), Pair("França", "Paris"))
    val h11: HashMap<String, String> = hashMapOf(Pair("França", "Paris"))
    h1["Alemanha"] = "Berlim"

    val m1 = mapOf(Pair("França", "Paris"), Pair("França", "Paris"))
    val m2 = mutableMapOf(Pair("França", "Paris"), Pair("França", "Paris"))

    println(l1)
    println(l2)
    println(s1)
    println(s2)
    println(h1)
    println(m1)
}