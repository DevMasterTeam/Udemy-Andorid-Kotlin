/**
 * Modificadores: public, private, protected
 * ---
 * public
 * Aberto para classes herdeiras e não herdeiras. Visibilidade ilimitada.
 * Classes e atributos já são public por padrão, não há necessidade de escrever explicitamente
 * --
 * private
 * Visibilidade somente dentro da classe.
 * --
 * protected
 * Visibilidade para a classe onde é declarada e classes herdeiras.
 * --
 * Vale a pena destacar que não são aplicadas apenas à classes, mas também métodos e atribuos.
 * Também é válido para construtores, uma vez que também são métodos.
 */
fun main() {
    val fig = Figura()

    // Não acessível
    // fig.funcaoProtected()
    // fig.funcaoPrivada()
}

open class Figura {
    protected fun funcaoProtected() {
    }

    private fun funcaoPrivada() {}
}

class Quadrado(lado: Int) : Figura() {
    fun area() {
        funcaoProtected()

        // Não acessível
        // funcaoPrivada()
    }
}