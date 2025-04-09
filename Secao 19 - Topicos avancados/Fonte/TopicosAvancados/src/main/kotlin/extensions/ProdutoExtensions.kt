package extensions

/**
 * Atributo de extensão
 * ---
 * Esse atributo NÃO modifica a classe original.
 * Ele não armazena valor – é sempre recalculado ao ser acessado.
 */
val Produto.descricao: String
    get() = "$nome custa R$ ${"%.2f".format(preco)}"

// Não é possível - Atributos de extensão não podem armazenar valores
// val Produto.abc: String = "abc"

/**
 * Função de extensão
 * ---
 * Adiciona um comportamento à classe Produto, como se fosse um método dela.
 * Não há herança ou modificação direta da classe.
 * Importante: não é possível acessar membros privados nem sobrescrever métodos.
 */
fun Produto.estaCaro(): Boolean {
    return (preco > 5)
}