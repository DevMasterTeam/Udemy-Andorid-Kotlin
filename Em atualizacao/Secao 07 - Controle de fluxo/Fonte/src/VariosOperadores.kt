fun main() {

    val a = false
    val b = false
    val c = true
    val d = true

    // Aqui a ordem de execução faz com que a condição seja satisfeita
    if (a && b || c && d) {
        println("sem parênteses")
    }

    // Aqui a ordem de execução faz com que a condição NÃO seja satisfeita
    // Ordem muda com a inclusão dos parênteses
    if (a && (b || c) && d) {
        println("com parênteses")
    }

    val n = 10
    // Operador range
    if (n in 1..50) {}

    // Alternativa para range
    if (n >= 1 && n <= 50) {}

}