fun exemplo1() {
    // O laço for inicia a iteração de 1 até 10
    for (i in 1..10) {
        // Imprime o valor atual da iteração seguido por um espaço
        print("$i ")
    }
}

fun exemplo2() {
    // O laço for inicia a iteração de 1 até 10 de 2 em 2
    for (i in 1..10 step 2) {
        print("$i ")
    }
}

fun exemplo3() {
    // O laço for inicia a iteração de 10 até 0 de 2 em 2
    for (i in 6 downTo 0 step 2) {
        print("$i ")
    }
}

fun exemplo4() {
    // Uma String nada mais é que uma cadeia de caracteres
    for (c in "Curso de Kotin") {
        print("$c ")
    }
}