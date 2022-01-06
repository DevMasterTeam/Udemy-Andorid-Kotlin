/**
 * Variáveis mutáveis pode ter seu valor alterado.
 * Variáveis imutáveis não podems ter seu valor alterado.
 *
 * Dicas
 * Kotlin sempre sugere que seja feito o uso de variáveis 'val' ao invés de 'var'. 2 motivos:
 * 1. Ao usar uma variável 'val' que não tenha sido atribuída, acontece erro de compilação
 * 2. É mais fácil saber qual o valor da variável, é mais controlável
 */
fun main() {

    // Declaração e alteração
    var nome = "Patrick"
    nome = "Tony"

    // Declaração e não é possível alterar
    val idade = 20

    // Resulta em erro
    // idade = 21

    // Variável somente declarada, nunca inicializada
    val litros: Int
    // Inicializada
    litros = 15

}