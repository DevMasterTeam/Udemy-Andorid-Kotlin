/*
    Type	    Bit     Intervalo
    Double	    64      [1.7976931348623157 x (10)^308, 4.9406564584124654 x (10)^-324]
    Float	    32      [3.40282347 x 10^(38), 1.40239846 x (10)^-45]
    Long	    64      [-9,223,372,036,854,775,808 - 9,223,372,036,854,775,807]
    Integer     32      [-2,147,483,648 - 2,147,483,647]
    Short	    16      [-32,768 .. 32,767]
    Byte	    8       [-128,127]
    Character   16      -
    String      ?       -
    Boolean     ?       [0,1]

    Lembrando sobre unidades de medida
    1 Byte = 8 bits
    1 kilobyte (kB) = 1024 bytes
    1 megabyte (MB) = 1024 kilobytes
    1 gigabyte (GB) = 1024 megabytes
*/

fun main() {
    println("Double: Max: " + Double.MAX_VALUE + " - Double: " + Double.MIN_VALUE)
    println("Float: Max: " + Float.MAX_VALUE + " - Min: " + Float.MIN_VALUE)
    println("Long: Max: " + Long.MAX_VALUE + " - Long: " + Long.MIN_VALUE)
    println("Int: Max: " + Int.MAX_VALUE + " - Min: " + Int.MIN_VALUE)
    println("Short: Max: " + Short.MAX_VALUE + " - Min: " + Short.MIN_VALUE)
    println("Byte: Max: " + Byte.MAX_VALUE + " - Min: " + Byte.MIN_VALUE)

    // Possível declarar uma variável sem tipo, desde que seja incializada.
    // Tipo de dado é definido através da inferência.
    var idade = 18

    // Isso não pode ser feito, a variável não sabe nem o valor, nem o tipo
    // var idade2

    // Variável declarada, mas não inicializada
    var idade3: Int

    // Atenção a declaração sem tipo
    val n1 = 10.0 // Qualquer número com ponto flutuante é tratado como Double
    val n2 = 10.0F // "F" ou "f" faz com que o tipo agora seja Float
    val n3 = 13 // Número inteiro, caso caiba dentro do Int, será inteiro
    val n4 = 13L // Long
    val n5 = 13 // Não existe sufixo para Byte ou Short, caso deseje um tipo Byte, deve ser explícito
}

/**
 * -- Anotações --
 * O tamanho Boolean pode ser representado somente com 1 bit, true ou false
 * Porém o tamanho é depende da JVM e a especificaçacão não deixa claro
 *
 * String
 * O tamanho de uma String depende de seu conteúdo.
 *
 * Fonte
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
 */