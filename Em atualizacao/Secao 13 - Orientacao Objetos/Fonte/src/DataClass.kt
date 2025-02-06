/**
 * Data class geralmente são classes usadas para transitar dados.
 * Possuem implementação de toString() para um formato legível, implementam o método copy, hashCode e equals.
 * ---
 * O comportamento do método toString() facilita a leitura de dados quando necessário.
 * Além disso, caso haja necessiadde do método hasCode e copy, já estão implementados.
 * ---
 * Regras para usar data class
 * 1. Precisam ter ao menos um atributo no construtor primário como var ou val
 * 2. Não podem ser abstratas
 */
fun main() {

    val datat1 = TrianguloDataClass(15f, 15f, 15f)
    val t1 = Triangulo(15f, 15f, 15f)

    val datat2 = TrianguloDataClass(15f, 15f, 15f)
    val t2 = Triangulo(15f, 15f, 15f)

    // Ao imprimir a instância da classe, há a facilidade com uso do data class
    println(datat1.toString())
    println(t1.toString())
    println("----------")

    // Ao fazer a comparação, o método equals é chamado.
    // Porém, ao fazer essa comparação com class, o que é comparado de fato é o endereço da instância na memória.
    // Ao usar data class, o que é comparado de fato são os valores dos atributos
    println(datat1 == datat2)
    println(t1 == t2)
    println("----------")

    // Data class considera o valor dos atributos, dessa maneira, valores gerados são iguais.
    println("${datat1.hashCode()} - ${datat2.hashCode()}")
    println("${t1.hashCode()} - ${t2.hashCode()}")
    println("----------")

    // Class não possui o método copy por padrão
    // t1.copy()

    // Data class tem o método copy por padrão
    datat1.copy(a = 14f)
}

class Triangulo(var a: Float, var b: Float, var c: Float)
data class TrianguloDataClass(var a: Float, var b: Float, var c: Float)