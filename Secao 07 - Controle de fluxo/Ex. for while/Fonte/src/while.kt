fun main() {
}

fun while1() {
    val caixa = 2000
    val balao = 7

    var numBaloes = 0
    var preenchimento = 0
    while (preenchimento + balao <= caixa) {
        numBaloes++
        preenchimento += balao
    }
    println("Na caixa d'água cabem $numBaloes balões.")
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
    val strLower = str.lowercase()

    var i = 0
    var countX = 0
    var countO = 0
    while (i < strLower.length) {
        if (strLower[i] == 'x') {
            countX++
        } else if (strLower[i] == 'o') {
            countO++
        }
        i++
    }

    return countO == countX && countO != 0
}