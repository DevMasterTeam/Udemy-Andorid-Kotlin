/**
 * O comando "if" é uma estrutura condicional em Kotlin usada para tomar decisões no código.
 * Ele avalia uma expressão booleana e executa um bloco de código caso a condição seja verdadeira.
 * Estrutura básica:
 * if (condição) {
 *      // Código a ser executado se a condição for verdadeira
 * }
*/

/**
 * Verifica se parâmetro passado é verdadeiro e imprime "Acorde!" caso seja.
 * */
fun saudacao(manha: Boolean) {
    if (manha) {
        println("Acorde!")
    }
}

/**
 * Faz a impressão de "Maior de idade", caso valor passado seja maior igual a 18.
 * */
fun maiorDeIdade(idade: Int) {
    if (idade >= 18) {
        println("Maior de idade")
    }
}

fun main() {
    saudacao(true)
    saudacao(false)

    maiorDeIdade(15)
    maiorDeIdade(21)
}