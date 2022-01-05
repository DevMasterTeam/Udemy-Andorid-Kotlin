/**
 * Diferente de grande parte das linguagens atuais, if else é uma expressão em Kotlin
 * Sendo uma expressão, ela é capaz de retornar valor.
 */
fun main() {
    println(maiorDeIdade3(15))
    println(maiorDeIdade3(26))
}

fun maiorDeIdade2(idade: Int) {
    if (idade >= 18) {
        println("Maior de idade.")
    } else {
        println("Menor de idade.")
    }
}

fun maiorDeIdade3(idade: Int): String {
    return if (idade >= 18) {
        "Maior de idade."
    } else {
        "Menor de idade."
    }
}