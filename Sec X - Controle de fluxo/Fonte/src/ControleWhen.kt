/**
 * Assim como if/else, when também é uma expressão e pode retornar valores.
 */
fun main() {
}

fun acontecimentoWhen(ano: Int) {
    when (ano) {
        in 0..1999 -> {
            println("Milênio passado")
        }
        in 2000..2003 -> {
            println("Presidente: Fernando Henrique Cardoso")
        }
        else -> {
            println("Deixemos pro futuro.")
        }
    }
}

fun operacao(a: Int, b: Int, operacao: String): Int {
    when (operacao) {
        "Soma" -> {
            return a + b
        }
        "Subtracao" -> {
            return a - b
        }
        else -> {
            return 0
        }
    }
}

fun operacao2(a: Int, b: Int, operacao: String): Int {
    return when (operacao) {
        "Soma" -> a + b
        "Subtracao" -> a - b
        else -> 0
    }
}