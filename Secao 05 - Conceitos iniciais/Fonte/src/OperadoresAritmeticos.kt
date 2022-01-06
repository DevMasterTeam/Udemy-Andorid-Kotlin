/**
 * Operadores
 *
 * Soma             ->  +
 * Subtração        ->  -
 * Divisão          -> /
 * Multiplicação    -> *
 * Resto da divisão -> %
 *
 */
fun main() {

    // Operações
    println("2 + 2 = ${2 + 2}")
    println("2 - 2 = ${2 - 2}")
    println("2 / 2 = ${2 / 2}")
    println("2 * 2 = ${2 * 2}")
    println("10 % 4 = ${10 % 4}")
    println("10 % 2 = ${10 % 2}")

    // Incremento e decremento
    var numero = 10

    println("numero++ = ${numero++}")
    println("numero-- = ${numero--}")

    println("++numero = ${++numero}")
    println("--numero = ${--numero}")

    // Operação e atribuição
    numero += 2
    println("numero+= 2 = $numero")

    numero -= 2
    println("numero-= 2 = $numero")

    numero /= 2
    println("numero/= 2 = $numero")

    numero *= 2
    println("numero*= 2 = $numero")

    numero %= 3
    println("numero%= 3 = $numero")

}