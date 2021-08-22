/**
 * Operador Elvis :?
 * Retorna a parte esquerda da expressão caso não seja nulo.
 * Se for nulo, retorna a parte direita.
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
}