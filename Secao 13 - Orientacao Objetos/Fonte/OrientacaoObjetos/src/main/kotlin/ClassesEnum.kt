/**
 * Classes enum permitem a definição de uma lista de valores dentro da classe.
 * Útil quando é necessário transitar um intervalo de valores conhecidos,
 * pois restringe as possibilidades e os erros.
 */
fun main() {

    // Por exemplo, uma classe que contenha os meses do ano.
    // Ou uma classe que tenha os dias da semana

    // Percorre a lista de valores
    for (p in PRIORIDADE.entries) {
        println(p)
    }

    // Valor associado a prioridade
    println(PRIORIDADE2.ALTA.id)
}

enum class PRIORIDADE {
    BAIXA, MEDIA, ALTA
}

enum class PRIORIDADE2(val id: Int) {
    BAIXA(1), MEDIA(5), ALTA(10)
}