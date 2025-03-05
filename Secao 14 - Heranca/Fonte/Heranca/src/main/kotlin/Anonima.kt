/**
 * Classe anônima é uma classe criada dentro de um método que pode ser passada como parâmetro.
 * Nesse caso, não houve a necessidade de se criar uma classe para então implementar a interface.
 * --
 * É como se criássemos uma classe sem nome, mas que implementa a interface.
 * --
 * Classes anônimas são muito poderosas, pois permitem que o código de uma classe seja invocado
 * a qualquer momento a partir de outra classe.
 */

interface Listener {
    fun click(id: Int)
}

class Principal {
    fun salvar(listener: Listener, id: Int) {
        listener.click(id)
    }
}

fun main() {
    val principal = Principal()
    val listener = object : Listener {
        override fun click(id: Int) {
            println("Fui clicado.$id")
        }
    }
    principal.salvar(listener, 10)
}