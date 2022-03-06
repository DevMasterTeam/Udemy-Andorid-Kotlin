/**
 * O modificador const só é permitido em declarações fora da classe ou
 * dentro de objects e companion objects. Isso é chamado de "top-level declaration"
 * que significa declarações de alto nível.
 *
 * Variáveis const só podem ser atribuídas valores fixos e nunca retorno de funções.
 */

// Declaração fora de classe
const val HELLO_WORLD = "Hello world"
val HELLO_WORLD_2 = "Hello world 2"
val HELLO_WORLD_3 = method()

// Não funciona
// const val foo = method()

class Const {
    companion object {
        const val bar = "Hello world"
    }

    object Constante {
        const val bar = "Hello world"
    }
}

fun method() = "Hello World 3"

fun main() {
}