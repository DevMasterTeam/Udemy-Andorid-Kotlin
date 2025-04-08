/**
 * Funções de Alta Ordem (High Order Functions)
 * --
 * São funções que recebem outras funções como parâmetro e/ou retornam funções.
 * --
 * São muito úteis para aplicar lógica personalizada, reutilizar código e
 * tornar as APIs mais flexíveis e expressivas.
 *
 * Exemplos comuns:
 * -> funções como map, filter, runBlocking
 * -> uso em callbacks
 */

fun main() {
    println("== Função que recebe outra função ==")
    executaOperacao(5, 3) { a, b -> a + b } // Soma
    executaOperacao(10, 4) { a, b -> a * b } // Multiplicação

    println("\n== Função que retorna outra função ==")
    val saudacao = retornaSaudacao("Olá")
    println(saudacao("Maria"))
}

/**
 * Exemplo de função de alta ordem:
 * Recebe dois números e uma operação como função
 */
fun executaOperacao(a: Int, b: Int, operacao: (Int, Int) -> Int) {
    val resultado = operacao(a, b)
    println("Resultado da operação: $resultado")
}

/**
 * Função que retorna outra função.
 * Personaliza a saudação.
 */
fun retornaSaudacao(prefixo: String): (String) -> String {
    return { nome -> "$prefixo, $nome!" }
}