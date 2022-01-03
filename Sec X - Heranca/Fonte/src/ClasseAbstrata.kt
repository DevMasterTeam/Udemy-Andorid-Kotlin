/**
 * A classe abstrata define alguns comportamentos que as classes que herdam devem ter.
 * Uma classe abstrata não pode ser instanciada, é usada para moldar classes que herdam seu comportamento.
 * Uma classe abstrata deve ter no mínimo um método abstrato. Assim, podem existir métodos já implementados.
 */
fun main() {
    val cachorro = Cachorro("Bolt")
    cachorro.falar()
    cachorro.nome()
}

abstract class Mamifero(val nome: String) {
    private var peso = 0f

    abstract fun falar()
    open fun nome() {
        println("Sou um mamífero: $nome")
    }
}

/**
 * Herda de mamífero
 * Implementa obrigatoriamente a função definida como abstrata na classe pai.
 * Não precisa implementar métodos que não são definidos como abstratos, mas poderia com o uso do override.
 */
class Cachorro(especie: String) : Mamifero(especie) {
    override fun falar() {
        println("Au au")
    }

    override fun nome() {
        super.nome()
    }
}