/**
 * Operador Elvis :?
 * O operador Elvis é uma forma concisa de lidar com valores nulos em Kotlin.
 * Ele verifica se a expressão à esquerda é `null`, e caso seja, retorna o valor à direita.
 * Se a expressão à esquerda não for `null`, seu próprio valor será retornado.
 * ------
 * O operador Elvis se parece com o operador ternário em Java, mas não são iguais.
 * Não existe operador ternário em Kotlin.
 */
fun main() {
    val str: String? = null

    // Verificação padrão usando if-else
    if (str == null) {
        println("NULO")
    } else {
        println(str)
    }

    // Uso do operador Elvis para simplificar a verificação de null
    println(str ?: "NULO")
}