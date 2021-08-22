/**
 * Diferente de grande parte das linguagens atuais, if else é uma expressão em Kotlin
 * Sendo uma expressão, ela é capaz de retornar valor.
 */
fun main() {
    bonusFuncionario(1)
    bonusFuncionario(2)
    bonusFuncionario(3)
    bonusFuncionario(4)
    bonusFuncionario(5)

    println(maiorDeIdade3(15))
    println(maiorDeIdade3(26))
}

fun bonusFuncionario(anosEmpresa: Int) {
    if (anosEmpresa >= 0) {
        println("Bônus padrão: R$200,00")
    } else {
        if (anosEmpresa >= 1 && anosEmpresa < 3) {
            println("Bônus: R$400,00")
        } else if (anosEmpresa >= 3 && anosEmpresa < 5) {
            println("Bônus: R$100,00")
        } else {
            println("Bônus: R$2000,00")
        }
    }
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