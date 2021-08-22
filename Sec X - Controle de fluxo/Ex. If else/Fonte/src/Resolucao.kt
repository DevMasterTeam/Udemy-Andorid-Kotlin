fun main() {
}

fun ex1() {
    print("Informe o primeiro valor: ")
    val lado1 = readLine()

    print("Informe o segundo valor: ")
    val lado2 = readLine()

    if (lado1 != null && lado2 != null) {
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

    if (lado1 != null && lado2 != null && lado3 != null) {
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

    print("Digite sua idade: ");
    var info = readLine()
    if (info == null) {
        return
    }
    val idade = info.toInt()

    if (idade < 18) {
        println("Negado. Menores de idade não são permitidos.")
    } else {
        print("Informe o tipo de convite: ")
        val tipo = readLine()

        if (tipo == null)
            return

        if (tipo == "comum" || tipo == "premium" || tipo == "luxo") {
            print("Informe o código: ")
            var codigo = readLine()

            if (codigo == null)
                return

            codigo = codigo.lowercase()

            if (tipo == "comum" && codigo.startsWith("xt")) {
                println("Welcome :)")
            } else if (codigo.startsWith("xl")) {
                println("Welcome :)")
            } else {
                println("Negado. Convite inválido.")
            }
        } else {
            println("Negado. Convite inválido.")
        }
    }
}