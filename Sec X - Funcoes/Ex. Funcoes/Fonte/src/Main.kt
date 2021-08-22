fun conversaoAnos(anos: Int) {
    println("$anos ano(s) equivale(m) a:")
    println("${anos * 12} meses")
    println("${anos * 365} dias")
    println("${anos * 365 * 24} horas")
    println("${anos * 365 * 24 * 60} minutos")
    println("${anos * 365 * 24 * 60 * 60} segunds")
}

fun tamanhoString(str: String): Int {
    return str.length
}

fun cubo(n: Int): Int {
    return n * n * n
}

fun milhasEmKm(milhas: Float): Float {
    return milhas * 1.6f
}

fun trocaLetras(str: String): String {
    return str.lowercase().replace("a", "x")
}

fun tamanhoStringUnicaLinha(str: String) = str.length
fun cuboUnicaLinha(n: Int) = n * n * n
fun milhasEmKmUnicaLinha(milhas: Float) = milhas * 1.6f

fun main() {
    conversaoAnos(2)
    println(tamanhoString("Programação Kotlin."))
    println(cubo(2))
    println(milhasEmKm(100f))
}