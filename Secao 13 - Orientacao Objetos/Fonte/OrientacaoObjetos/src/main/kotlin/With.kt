import gettersetter.Person

fun main() {
    val str = "Programação Kotlin"

    str.uppercase()
    str.lowercase()
    val size = str.length

    // Faz o uso da instância da classe para chamar diversos métodos
    // Pode-se ler "com esse objeto, faça.."
    with(str) {
        uppercase()
        lowercase()
        val size = length
    }

    // Nesse caso, a instância é criada e existe somente no escopo de "with"
    // Uma vez que o trecho de código é executado, a instância deixa de existir.
    with(Person(15)) {
        println("Idade: $idade")
    }
}