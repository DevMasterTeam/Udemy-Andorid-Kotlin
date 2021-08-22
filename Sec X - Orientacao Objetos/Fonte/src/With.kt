fun main() {
    val str = "Programação Kotlin"

    str.uppercase()
    str.lowercase()
    val size = str.length

    // Faz o uso da instância da classe para chamar diversos métodos
    // Scope function
    // Pode-se ler "com esse objeto, faça.."
    with(str) {
        uppercase()
        lowercase()
        val size = length
    }
}