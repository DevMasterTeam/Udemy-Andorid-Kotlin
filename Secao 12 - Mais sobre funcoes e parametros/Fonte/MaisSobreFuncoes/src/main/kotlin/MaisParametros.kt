/**
 * Funções podem ter parâmetros com valor default - Caso não informado, assume o valor especificado.
 * Default significa padrão.
 */
fun main() {
    endereco(rua = "dfhgdk", estado = "SP")
}

/**
 * Parâmetro cep se torna opcional dessa maneira.
 * Caso não informado, assume o valor de String vazia.
 * */
fun endereco(rua: String, cidade: String = "", estado: String, cep: String = "") {
    println("Rua: $rua")
    println("Cidade: $cidade, $estado - $cep")
}