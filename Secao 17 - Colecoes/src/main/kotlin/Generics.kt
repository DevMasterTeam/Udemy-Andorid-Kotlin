/**
 * Função genérica que recebe um valor do tipo T e retorna
 * O uso de <T> permite que a função aceite qualquer tipo de dado
 * */
fun <T> empacotar(x: T): T {
    return x
}

/**
 * Classe genérica MyClass que trabalha com qualquer tipo T
 * Isso permite maior reutilização e flexibilidade do código
 * */
class MyClass<T> {
    // Lista para armazenar os valores
    private val items = mutableListOf<T>()

    // Método para salvar um valor na lista
    fun save(value: T) {
        items.add(value)
        println("Valor salvo: $value")
    }

    // Método para deletar um valor da lista
    fun delete(value: T) {
        if (items.remove(value)) {
            println("Valor removido: $value")
        } else {
            println("Valor não encontrado: $value")
        }
    }

    // Método para listar todos os valores armazenados
    fun listAll(): List<T> {
        return items
    }
}

fun main() {

    // Exemplo de uso da função genérica
    val numeroEmpacotado = empacotar(10)
    val textoEmpacotado = empacotar("Olá")
    println("Número empacotado: $numeroEmpacotado")
    println("Texto empacotado: $textoEmpacotado")

    // Exemplo de uso da classe genérica com Int
    val intStorage = MyClass<Int>()
    intStorage.save(42)
    intStorage.save(99)
    intStorage.delete(42)
    println("Itens armazenados: ${intStorage.listAll()}")

    // Exemplo de uso da classe genérica com String
    val stringStorage = MyClass<String>()
    stringStorage.save("Kotlin")
    stringStorage.save("Genéricos")
    stringStorage.delete("Kotlin")
    println("Itens armazenados: ${stringStorage.listAll()}")
}