fun main() {

    val kotlin = "Kotlin " + "é show"
    println(kotlin)

    val nome = "Charles " +
            "Babbage"

    // Uso do $ para concatenar String se chama interpolação
    println("Nome é $nome")
    println("Tamanho do nome é de ${nome.length} caracteres.")

    val linguagem = "Kotlin"
    val caracteristica = "É show!"
    val strFinal = linguagem + " " + caracteristica
    println("$linguagem $caracteristica")
}