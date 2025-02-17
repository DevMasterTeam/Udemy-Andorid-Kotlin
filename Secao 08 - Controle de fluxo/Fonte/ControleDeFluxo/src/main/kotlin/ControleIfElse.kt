/**
 * Em Kotlin, if else é uma expressão; Sendo uma expressão, ela é capaz de retornar valor.
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

/**
 * If else usado diretamente no return
 * */
fun maiorDeIdade3(idade: Int): String {
    return if (idade >= 18) {
        "Maior de idade."
    } else {
        "Menor de idade."
    }
}

/**
 * Retorna diretamente o resultado da expressão (true / false)
 * */
fun maiorDeIdade4(idade: Int): Boolean {
    return (idade >= 18)
}

/** Valor da mensalidade de cursos
informatica - 500
geografia - 600
 */
fun mensalidadeCurso(curso: String): Double {
    var mensalidade = -1.0

    if (curso == "informatica") {
        mensalidade = 500.0
    } else if (curso == "geografia") {
        mensalidade = 600.0
    }

    return mensalidade
}