import gettersetter.Person

fun main() {
    val str = "Programação Kotlin"

    // Uso de apply para modificar o objeto e retorná-lo
    // Apply não é capaz de retornar a últuma expressão (with é capaz)
    val modifiedStr = str.apply {
        lowercase()
        uppercase()
        length // Não altera o objeto, apenas acessa a propriedade
    }

    println("String original: $str")
    println("String modificada: $modifiedStr")

    // Criando e modificando uma instância de Person com apply
    val person = Person(15).apply {
        idade = 20
    }

    println("Idade modificada: ${person.idade}")
}