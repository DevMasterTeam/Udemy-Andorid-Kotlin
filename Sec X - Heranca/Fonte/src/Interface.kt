/**
 * Interfaces podem conter declarações de métodos que serão sobrescritos e também métodos com implementação.
 * Os métodos que serão sobrescritos precisam estar com assinatura e tipo de retorno definido,
 * não há necessidade de haver corpo.
 *
 * A diferença de interface com classe abstrata é que interfaces não podem armazenar estados.
 * Ou seja, os atributos da classe não podem ter valores.
 * */

fun main() {
    val a1 = ImplementsInterface()
    a1.ola()
}

interface Interface1 {
    fun teste()
}

interface Interface2 {
    fun ola() {
        println("Olá interface 2!")
    }

    fun tchau()
}

class ImplementsInterface : Interface1, Interface2 {
    override fun teste() {
        println("Sobrescrita")
    }

    override fun tchau() {
        println("Adeus")
    }
}