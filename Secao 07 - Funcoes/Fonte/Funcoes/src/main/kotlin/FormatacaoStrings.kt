import java.util.Locale

fun main() {

    // Concatenação de Strings
    val nome = "John"
    println("Olá, $nome")

    // No entanto, é possível utilizar formatação de String para evitar concatenação.
    println("Olá, %s".format(nome))

    // Tipos de dados e especificadores
    // %s - String
    // %d - Integer
    // %f - Ponto flutuante
    // %c - Character
    // %b - Boolean

    val valor = 5
    val salario = 8451.54f

    println("Valor eh de %d e salario eh de %f".format(valor, salario))
    println()

    // Formatando números corretamente
    println("Valor eh de %02d e salario eh de %.2f".format(valor, salario))
    println()

    // Garantindo que o formato decimal use ponto (.) e não vírgula (,)
    println("Valor é de %02d e salário é de %.2f".format(Locale.US, valor, salario))
}