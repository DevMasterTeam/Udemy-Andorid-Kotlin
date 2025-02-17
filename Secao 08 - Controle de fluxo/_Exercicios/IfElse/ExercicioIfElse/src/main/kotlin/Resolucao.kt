fun ex1() {
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

fun ex2() {
    print("Informe o primeiro numero: ")
    val lado1 = readLine().toString().toInt()

    print("Informe o segundo numero: ")
    val lado2 = readLine().toString().toInt()

    print("Informe o terceiro numero: ")
    val lado3 = readLine().toString().toInt()

    if (lado1 == lado2 && lado2 == lado3) {
        println("É um triângulo equilátero!")
    } else {
        println("Não é um triângulo equilátero!")
    }
}

fun ex3(num: Int) {
    if (num >= 0) {
        if (num == 0) {
            println("Primeira string")
        } else {
            println("Segunda string")
        }
    }
    println("Terceira string")
}