fun main() {
}

fun while1() {
    val capacidadeCaixa = 2000
    val volumeBalao = 7
    var numeroBaloes = 0

    while ((volumeBalao * numeroBaloes) + volumeBalao <= capacidadeCaixa) {
        numeroBaloes++
    }

    println("Cabem $numeroBaloes balões.")
}

fun while2() {
    var i = 1
    while (i <= 50) {
        if (i % 15 == 0) {
            print(" FizzBuzz")
        } else if (i % 3 == 0) {
            print(" Buzz")
        } else if (i % 5 == 0) {
            print(" Fizz")
        } else {
            print(" $i")
        }
        i++
    }
}

fun while3(str: String) {
    var length: Int = str.length

    // Caso seja necessário retornar a string invertida
    // var inverso = "";
    while (length > 0) {
        print(str[length - 1])
        // inverso += str[length - 1]
        length--
    }
}

fun while4(str: String): Boolean {
    val texto = str.lowercase()
    var countX = 0
    var countO = 0

    var length = texto.length
    while (length > 0) {
        if (texto[length - 1] == 'x') {
            countX++
        }
        if (texto[length - 1] == 'o') {
            countO++
        }
        length--
    }

    return (countX == countO && countO != 0)
}