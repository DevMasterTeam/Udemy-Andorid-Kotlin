/**
 * SAM - Single Abstract Method
 * Interfaces que definem um único método abstrato. (Também são chamadas de interfaces funcionais)
 * --
 * Para definir uma interface funcional, use fun antes da palavra interface
 * */
fun interface Acao {
    fun click(id: Int)
}

class Main {
    fun salvar(acao: Acao, id: Int) {
        acao.click(id)
    }
}

fun main() {
    val main = Main()

    // Caso o corpo possua somente uma instrução
    val implementacao1 = Acao { x -> println(x) }

    // Caso o parâmetro não seja usado no corpo, pode ser substituído por _
    val implementacao2 = Acao { _ -> println() }

    // Caso o corpo tenha mais de uma instrução, não há problema
    val implementacao3 = Acao { _ ->
        println("instrução 1")
        println("instrução 2")
    }

    // Lambda criado em variável
    main.salvar(implementacao3, 15)

    // Lambda criado dentro da própria chamada
    main.salvar({ id -> println("Fui clicado com id $id") }, 10)
}