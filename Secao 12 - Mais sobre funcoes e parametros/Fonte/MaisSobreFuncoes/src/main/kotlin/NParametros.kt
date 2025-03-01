/**
 * Função que calcula a média aritmética de um conjunto de valores do tipo Float.
 * Utiliza o parâmetro vararg, permitindo um número variável de argumentos.
 */
fun media(vararg notas: Float) {
    var soma = 0f
    for (i in notas) {
        soma += i
    }
    println("Média: ${soma / notas.size}")
}

fun main() {
    media(12f, 8f, 4f, 97.3f)
}