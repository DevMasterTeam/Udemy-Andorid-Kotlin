/**
 * Substitui todas as ocorrências da letra 'a' por 'x' em uma string fornecida.
 * A string é convertida para minúsculas antes da substituição.
 */
fun trocaLetras(str: String) {
    // Converte a string para minúsculas e substitui 'a' por 'x'
    println(str.lowercase().replace("a", "x"))
}

/**
 * Solicita ao usuário que insira um texto, lê a entrada e a processa usando a função trocaLetras.
 * Caso a entrada seja nula, converte para uma string vazia para evitar exceções.
 */
fun lerString() {
    print("Informe um texto: ")
    // Lê a entrada do usuário
    val texto = readLine()
    trocaLetras(texto.toString())
}

/**
 * Ponto de entrada
 */
fun main() {
    lerString()
}
