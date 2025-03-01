/**
 * Any
 * Todos objetos em Kotlin herdam de Any, ou seja,
 * Any é um super tipo de todos os outros existentes em Kotlin.
 * ---------------------
 * Nothing
 * Este tipo não existe em Java. Nothing é um tipo somente existente em Kotlin.
 * Diferente de Unit, se usado no retorno de uma função não quer dizer que não retorna nulo,
 * mas sim que não tem retorno algum. Uma função que retorna Nothing não pode ter retorno.
 * Geralmente é usado em funções para retornar erros. Indica que a função nunca completará "normalmente".
 */
fun main() {
    valores(1)
    valores("String")
    valores(true)
}

// Aceita qualquer tipo de valor
fun valores(value: Any) {}

/**
 * Utiliza vararg para aceitar múltiplos tipos e verifica cada tipo dentro da função.
 */
fun processaValores(vararg valores: Any) {
    for (valor in valores) {
        when (valor) {
            is Int -> println("Inteiro: $valor")
            is Float -> println("Float: $valor")
            is Double -> println("Double: $valor")
            is String -> println("String: $valor")
            is Boolean -> println("Booleano: $valor")
            else -> println("Tipo desconhecido: $valor")
        }
    }
}

// Não pode ter retorno, sequer Unit
fun validacao(value: String): Nothing {
    throw Exception(value)
}