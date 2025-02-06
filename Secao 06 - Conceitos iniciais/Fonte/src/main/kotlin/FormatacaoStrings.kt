fun main() {

    val kotlin = "Kotlin " + "é show"
    println(kotlin)

    // Escrevendo String em linhas diferentes
    val nome = "Charles " +
            "Babbage"

    // Uso do $ para concatenar String se chama interpolação
    println("Nome é $nome")
    println("Tamanho do nome é de ${nome.length} caracteres.")

    val linguagem = "Kotlin"
    val caracteristica = "é show!"

    // Concatenação "manual"
    val strFinal = linguagem + " " + caracteristica

    // Usando recurso Kotlin para concatenação
    println("$linguagem $caracteristica")
}