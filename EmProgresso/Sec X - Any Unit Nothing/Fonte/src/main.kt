/**
 * Any
 * Todos objetos em Kotlin herdam de Any, ou seja,
 * Any é um super tipo de todos os outros existentes em Kotlin.
 *
 * Unit
 * Mesmo funcionamento do void no Java.
 * Em funções, significa que não existe retorno, a função simplesmente executa e termina.
 *
 * Nothing
 * Este tipo não existe em Java. Nothing é um tipo somente existente em Kotlin.
 * Diferente de Unit, se usado no retorno de uma função não quer dizer que não retorna nulo,
 * mas sim que não tem retorno algum. Uma função que retorna Nothing não pode ter retorno.
 * Geralmente é usado em funções para retornar erros.
 */
fun main() {
    valores(1)
    valores("String")
    valores(true)
}

// Aceita qualquer tipo de valor
fun valores(value: Any): Unit {
}

// Não pode ter retorno, sequer Unit
fun validacao(value: String): Nothing {
    throw Exception(value)
}