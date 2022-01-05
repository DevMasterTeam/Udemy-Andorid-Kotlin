fun main() {
}

fun ex1() {
    print("Informe o primeiro valor: ")
    val lado1 = readLine()

    print("Informe o segundo valor: ")
    val lado2 = readLine()

    if (lado1 != "" && lado2 != "") {
        if (lado1 == lado2) {
            println("Quadrado")
        } else {
            println("Retângulo")
        }
    }
}

fun ex2() {
    print("Informe o primeiro valor: ")
    val lado1 = readLine()

    print("Informe o segundo valor: ")
    val lado2 = readLine()

    print("Informe o terceiro valor: ")
    val lado3 = readLine()

    if (lado1 != "" && lado2 != "" && lado3 != "") {
        if ((lado1 == lado2) && (lado2 == lado3)) {
            println("Equilátero")
        } else {
            println("Isósceles ou escaleno")
        }
    }
}

fun qualASaida(num: Int) {
    if (num >= 0) {
        if (num == 0)
            println("Primeira string")
        else println("Segunda string")
    }
    println("Terceira string")
}

fun portaria() {
    print("Qual sua idade? ")
    val idade = readLine()

    if (idade != null && idade != "") {
        if (idade.toInt() < 18) {
            println("Negado. Menores de idade não são permitidos.")
            return
        }
    }

    print("Qual é o tipo de convite? ")
    var tipoConvite = readLine()

    if (tipoConvite != null && tipoConvite != "") {
        tipoConvite = tipoConvite.lowercase()

        // Validação do tipo de convite
        if (tipoConvite != "comum" && tipoConvite != "premium" && tipoConvite != "luxo") {
            println("Negado. Convite inválido.")
            return
        }

        print("Qual o código do convite? ")
        var codigo = readLine()

        if (codigo != null && codigo != "") {
            codigo = codigo.lowercase()

            if (tipoConvite == "comum" && codigo.startsWith("xt")) {
                println("Welcome :)")
            } else if ((tipoConvite == "premium" || tipoConvite == "luxo") && codigo.startsWith("xl")
            ) {
                println("Welcome :)")
            } else {
                println("Negado. Convite inválido")
            }
        }
    }
}