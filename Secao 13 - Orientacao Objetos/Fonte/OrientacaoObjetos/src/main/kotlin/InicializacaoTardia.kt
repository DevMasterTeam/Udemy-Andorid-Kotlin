/**
 * Em alguns casos, é necessário que hava um processamento ou uma lógica antes da atribuição do valor a variável.
 * Para isso e também evitar declarar a variável como nula, é usado a palavra lateinit.
 *
 * Variáveis declaradas com lateinit não são alocadas na memória até que sejam inicializadas.
 *
 * Variáveis lateinit não podem ser declaradas como val
 * Variáveis lateinit não podem ser Int, Long, Short, Byte, Boolean, Char, Float, Double
 *
 * Variáveis da classe, em Kotlin, deve ser initializadas ou serem abstratas.
 * Assim, se existe a necessidade de uma variável no escopo da classe e não pode ainda ser inicializada,
 * ou devem ser passíveis de nulo ou declaradas como lateinit
 */
fun main() {
    val receita = Receita()

    // Acessar a variável sem antes inicializar resulta em erro.
    // println(receita.instrucoes)

    receita.geraReceita()
    println(receita.instrucoes)
}

class Receita {
    lateinit var instrucoes: String

    // Não é possível declarar uma variável sem atribuir valor
    //var instrucoes2: String

    fun geraReceita() {
        // Verifica se variável já foi inicializada
        if (!::instrucoes.isInitialized) {
            // Preenchimento através da função
            instrucoes = "Lave as mãos."
        }
    }
}