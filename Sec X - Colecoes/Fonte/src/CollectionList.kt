/**
 * Listas
 */
fun main() {

    // Lista imutável
    val lista1 = listOf(1, 2, 3, 4, 5, 6, 6) // Inferência de tipo
    var lista2: List<Int> = listOf(1, 2) // Declaração explícita

    println("Lista, posição 0: ${lista1[0]}")
    println("Tamanho da lista: ${lista1.size}")

    // Lista mutável
    val lista3 = mutableListOf(1, 2, 3, 4, 5, 6, 6)
    var lista4: MutableList<Int> = mutableListOf(1, 2)

    println()
    println("Tamanho da lista 3: ${lista3.size}")

    // Alterando lista mutável
    lista3.add(100)
    lista3.add(100)
    lista3.add(8)
    lista3.remove(2)

    println("Tamanho da lista 3: ${lista3.size}")
    println(lista3)

    // Verifica se existe um elemento
    println(lista3.contains(8))

    // Limpando a coleção - Somente possível em mutável
    lista3.clear()
}