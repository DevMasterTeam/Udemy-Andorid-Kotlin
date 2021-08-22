import kotlin.reflect.typeOf

fun main() {
    media(12f, 8f, 4f, 97.3f)
}

// Não existe limite para a quantidade de parâmetros.
fun media(vararg notas: Float) {
    var soma = 0f
    for (i in notas) {
        soma += i
    }
    println("Média: ${soma / notas.size}")
}

// Aceita qualquer tipo de parâmetro com quantidade ilimitada.
fun <T> generico(vararg params: T) {
    println("Existem ${params.size} parâmetros!")

    // Percorre a lista
    for (p in params) {
        // Verifica o tipo dos parâmetros recebidos
        when (p) {
            is String -> {
            }
            is Int -> {
            }
            is Float -> {
            }
        }
    }

}