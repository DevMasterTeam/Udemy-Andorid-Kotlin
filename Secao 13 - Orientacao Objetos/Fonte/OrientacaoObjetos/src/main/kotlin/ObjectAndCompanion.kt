/**
 * companion object - Sempre somente UM por classe. Pode ou não ser nomeado.
 * object - Quantos desejar por classe. Deve ter nome.
 * --
 * É comparável ao static do Java. Siginifica que os atributos e funcionalidades estão definidos
 * no escopo da classe.
 * --
 * Ambos companion object e object são inicializados a primeira vez que são acessados.
 * Nas demais vezes, o valor já está disponível na execução do programa.
 */
class Matematica {
    var id: Int = 10

    companion object {
        val PI = 3.1415

        fun abc() {
            println("Sou a classe Matemática")
        }

        init {
            println("Fui chamado!")
        }
    }

    object OBJ1 {
        fun abc() {}

        init {
            println("Fui chamado! OBJ1")
        }
    }
}

fun main() {
    Matematica.OBJ1.abc()
    Matematica.OBJ1.abc()
    Matematica.OBJ1.abc()
    Matematica.OBJ1.abc()
    Matematica.OBJ1.abc()
}