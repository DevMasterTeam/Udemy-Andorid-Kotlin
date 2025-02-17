fun imprimeImpares() {
    for (i in 1..10) {
        if (i % 2 == 0) {
            // Pula a impressão se o número for par
            continue
        }
        println(i)  // Só imprime ímpares
    }
}

fun main() {

    var i = 0
    while (true) {
        if (i == 10) {
            // Quebra o laço de repetição mesmo que a condição de execução seja verdadeira
            break
        }
        i++
    }

    while (i <= 100) {
        if (i < 95) {
            i++

            // Continue faz com que o laço de repetição passe para a próxima iteração
            continue

            println("Eu nunca serei executado.")
        }
        print("$i ")
        i++
    }
}