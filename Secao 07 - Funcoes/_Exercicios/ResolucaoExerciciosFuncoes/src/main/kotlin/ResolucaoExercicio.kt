fun exercicio1(anos: Int) {
    val meses = anos * 12
    val dias = anos * 365
    val horas = dias * 24
    val minutos = horas * 60
    val segundos = minutos * 60

    println("$anos ano(s) corresponde(m) a:")
    println("$meses meses")
    println("$dias dias")
    println("$horas horas")
    println("$minutos minutos")
    println("$segundos segundos")
}

fun exercicio2(input: String): Int {
    return input.length
}

fun exercicio3(numero: Double): Double {
    return numero * numero * numero
}

fun exercicio4(milhas: Double): Double {
    return milhas * 1.6
}

fun exercicio5(celsius: Double): Double {
    return (celsius * 9 / 5) + 32
}

fun exercicio2UnicaLinha(input: String): Int = input.length

fun exercicio3UnicaLinha(numero: Int): Int = numero * numero * numero

fun exercicio4UnicaLinha(milhas: Double): Double = milhas * 1.6

fun exercicio5UnicaLinha(celsius: Double): Double = (celsius * 9 / 5) + 32

fun main() {
    exercicio1(2)
    println(exercicio2("abcde")) // 5
    println(exercicio3(3.0)) // 27
    println(exercicio4(100.0)) // 160
    println(exercicio5(32.0)) // 89,6
}