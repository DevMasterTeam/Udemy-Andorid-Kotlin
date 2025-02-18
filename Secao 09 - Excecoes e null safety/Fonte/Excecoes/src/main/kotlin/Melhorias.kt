/**
 * Escreva um programa capaz de ler dois números inteiros que representam os lados de uma figura geométrica.
 * Informar se formam um quadrado (lados iguais).
 * */

/**
 * Resolução feita sem os conhecimentos da seção atual
 * */
fun resolucaoAntiga() {
    print("Digite o primeiro lado: ")
    val lado1 = readLine().toString().toInt()

    print("Digite o segundo lado: ")
    val lado2 = readLine().toString().toInt()

    if (lado1 == lado2) {
        println("Os lados formam um quadrado.")
    } else {
        println("Os lados não formam um quadrado.")
    }
}

/**
 * Lê um número inteiro positivo a partir do console.
 * Continua solicitando até que uma entrada válida seja fornecida.
 * Resolução usando do..while.
 */
fun leituraValorInteiroPositivo(str: String): Int {
    var valor = -1
    do {
        print(str)
        val input = readLine()
        if (input != null) {
            try {
                val numero = input.toInt()
                if (numero >= 0) {
                    valor = numero
                } else {
                    println("Informe um valor positivo!")
                }
            } catch (excp: Exception) {
                println("Informe um valor válido!")
            }
        } else {
            println("Informe um valor válido!")
        }
    } while (valor == -1)

    return valor
}

/**
 * Lê um número inteiro positivo a partir do console.
 * Continua solicitando até que uma entrada válida seja fornecida.
 * Resolução usando while.
 */
fun leituraValorInteiroPositivoWhile(str: String): Int {
    while (true) {
        print(str)
        val input = readLine()
        if (input != null) {
            try {
                val numero = input.toInt()
                if (numero >= 0) {
                    return numero
                } else {
                    println("Informe um valor positivo!")
                }
            } catch (excp: Exception) {
                println("Informe um valor válido!")
            }
        } else {
            println("Informe um valor válido!")
        }
    }
}

fun main() {
    val lado1 = leituraValorInteiroPositivo("Digite o primeiro lado: ")
    val lado2 = leituraValorInteiroPositivo("Digite o segundo lado: ")

    if (lado1 == lado2) {
        println("Os lados formam um quadrado.")
    } else {
        println("Os lados não formam um quadrado.")
    }
}