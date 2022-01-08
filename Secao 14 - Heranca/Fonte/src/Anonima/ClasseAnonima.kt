package Anonima

/**
 * Classe anônima funciona como uma herança temporária.
 * No exemplo abaixo, não existe nome algum para o object, mas ele é capaz de implementar a interface.
 * É como se existisse uma classe sendo definida e que estivesse implementando Event.
 * --
 * Isso tráz uma possibilidade extremamente poderosa de passar comportamentos por parâmentros.
 */
fun main() {

    val programa = Programa()
    programa.salvar(object : Event {
        override fun onClose() {
            // Comportamento
            println("Salvo")
        }
    })

    programa.salvar(object : Event {
        override fun onClose() {
            // Comportamento
            val str = "Atualizado"
            println(str)
        }
    })

}