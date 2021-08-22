/**
 * Modificadores: public, private, protected
 * ---
 * public
 * Aberto para classes herdeiras e não herdeiras. Visibilidade ilimitada.
 * --
 * private
 * Visibilidade somente dentro da classe.
 * --
 * protected
 * Visibilidade para a classe onde é declarada e classes herdeiras.
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