/**
 * Variáveis armazenam valores que podem ser usados posteriormente dentro de um programa.
 * Toda variável possui um tipo. É o tipo de dado que diz qual o valor que pode ser armazenado.
 * Toda variável possui um nome, é como ela é referenciada dentro do programa.
 *
 * Nenhuma variável pode ser declarada com uma palavra reservada.
 * Palavra reservada são palavras usadas para a linguagem, como fun, var, val, Int, String, etc.
 */
fun main() {

    // Variável do tipo String explicitamente declarada
    var nome: String = "Jane"

    // Variável sem definição de tipo. Kotlin faz a inferência.
    var nome1 = "Jane"

    // Usando variável nome
    println("Olá, $nome!")

}