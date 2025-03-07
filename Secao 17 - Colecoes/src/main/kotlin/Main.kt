/**
 * Coleçõs - Agrupamento de valores
 * Uma coleção geralmente contém um número de objetos (também pode ser zero) do mesmo tipo.
 *
 * Os tipos de coleção abaixo serão tratados:
 * - List
 * - Set
 * - Map
 *
 * Coleções podem ser mutáveis ou imutáveis. Assim como as variáveis declaradas com var e val,
 * seguem o mesmo conceito.
 *
 * Mutáveis - Uma vez criada, podem ser alteradas para adicionar, remover ou atualizar valores.
 * Imutáveis - Uma vez criada, não é possível adicionar ou remover valores, somente obter.
 */
fun main() {

    // Inicializa dados
    val data = listaDeDados()

    // Tenho receitas na lista?
    println("Tenho receitas? ${if (data.any()) "sim" else "não"}.")

    // Quantas receitas tenho na coleção?
    println("Tenho ${data.count()} receitas.")

    // Tenho alguma receita de Lasanha?
    println("Tenho receitas de Lasanha? ${if (data.any { it.nome == "Lasanha" }) "sim" else "não"}.")

    // Quantas receitas de Lasanha?
    println("Tenho ${data.count { it.nome == "Lasanha" }} receitas de Lasanha.")

    // Qual a primeira e última receita?
    println("A primeira receita é: ${data.first().nome}.")
    println("A última receita é: ${data.last().nome}.")

    // Caso a lista possa ser vazia - Evita que uma exceção seja lançada
    // data.firstOrNull()
    // data.lastOrNull()

    // Qual a soma de calorias do todas as receitas?
    val sumCalories = data.sumOf { it.calorias }
    println("A soma de calorias é: $sumCalories")

    // Sei como fazer panqueca? E sushi?
    val knowPanqueke = data.any { it.nome == "Panqueca" }
    println("Sei fazer panqueca? ${if (knowPanqueke) "sim" else "não"}")

    val knowSushi = data.any { it.nome == "Sushi" }
    println("Sei fazer sushi? ${if (knowSushi) "sim" else "não"}")

    // Me dê as duas primeiras receitas
    val firstTwo = data.take(2).forEach { println(it.nome) }

    // Quais são as comidas com mais de 500 calorias?
    data.filter { it.calorias > 500 }.forEach { println(it.nome) }

    // Qual a receita mais calórica? E a menos calórica?
    val maisCal = data.maxByOrNull { it.calorias }
    println("Mais calórica: ${maisCal?.nome}")

    val menosCal = data.minByOrNull { it.calorias }
    println("Menos calórica: ${menosCal?.nome}")

    // Faça uma lista com o nome dos pratos
    data.map { it.nome }.forEach { println(it) }

    // Qual a média de caloria de todas as receitas?
    val media = data.map { it.calorias }.average()
    println("A média de calorias é: $media.")

    // Lista de dados simples
    val listaInteiros = listOf(1, 2, 6, 67, 7, 3, 34, 56, 3, 3, 2, 5, 34, 2)
    println("Lista distinta: ${listaInteiros.distinct()}.")

    // Eliminar receitas com mesmo nome
    println(data.distinctBy { it.nome })

    // Ordenar uma lista - Crescente
    listaInteiros.sorted()

    // Ordenar uma lista - Decrescente
    listaInteiros.sortedDescending()

    // Inverter uma lista
    listaInteiros.reversed()

    // Exemplo concatenando várias ações
    val frutas = listOf("banana", "avocado", "apple", "kiwifruit")
    frutas
        .filter { it.startsWith("a") }
        .sorted()
        .map { it.uppercase() }
        .forEach { println(it) }
}

/**
 * Retorna lista de dados
 * */
private fun listaDeDados(): List<Receita> {
    return listOf(
        Receita(
            "Lasanha", 1200,
            listOf(
                Ingrediente("Presunto", 5),
                Ingrediente("Queijo", 10),
                Ingrediente("Molho de tomate", 2),
                Ingrediente("Manjerição", 3)
            )
        ),
        Receita("Panqueca", 500),
        Receita("Omelete", 200),
        Receita("Parmegiana", 700),
        Receita("Sopa de feijão", 300),
        Receita(
            "Hamburguer", 2000,
            listOf(
                Ingrediente("Pão", 1),
                Ingrediente("Hamburguer", 3),
                Ingrediente("Queijo", 1),
                Ingrediente("Catupiry", 1),
                Ingrediente("Bacon", 3),
                Ingrediente("Alface", 1),
                Ingrediente("Tomate", 1)
            )
        )
    )
}

// Classes de dados
data class Receita(val nome: String, val calorias: Int, val ingredientes: List<Ingrediente> = listOf())
data class Ingrediente(val nome: String, val quantidade: Int)