/**
 * Em alguns casos, é necessário que hava um processamento ou uma lógica antes da atribuição do valor a variável.
 * Para isso e também evitar declarar a variável como nula, é usado a palavra lateinit.
 */
fun main() {
    val receita = Receita()
    println(receita.instrucoes)
}

class Receita {
    lateinit var instrucoes: String

    fun geraReceita() {
        // Preenchimento através da função
        instrucoes = ""
    }
}