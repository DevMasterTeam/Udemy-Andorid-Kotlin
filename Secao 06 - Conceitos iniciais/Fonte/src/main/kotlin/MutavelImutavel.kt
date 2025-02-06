/**
 * Variáveis mutáveis podem ter seu valor alterado.
 * Variáveis imutáveis não podem ter seu valor alterado.
 *
 * Dicas
 * Kotlin sempre sugere que seja feito o uso de variáveis 'val' ao invés de 'var', pois
 * isso ajuda a evitar efeitos colaterais indesejados, garantindo que os valores não sejam modificados por engano.
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