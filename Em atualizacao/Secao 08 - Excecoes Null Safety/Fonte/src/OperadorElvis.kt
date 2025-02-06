/**
 * Operador Elvis :?
 * Se a parte esquerda da expressão for nulo, retorna a parte da direita.
 */
fun main() {
    val str: String? = null

    // Verificação padrão
    if (str == null) {
        println("NULO")
    } else {
        println(str)
    }

    println(str ?: "NULO")


    // TODO Não existe operador ternário em Kotlin

}