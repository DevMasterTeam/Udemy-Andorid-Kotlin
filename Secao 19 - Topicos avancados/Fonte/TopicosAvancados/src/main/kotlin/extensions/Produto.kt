package extensions

/**
 * Classe de Produto sem o modificador 'open'. Ou seja, não é possível de ser herdada.
 * */
class Produto(val nome: String, val preco: Double)

/**
 * Funções e atributos de extensão geralmente são declarados no nível superior (top-level),
 * ou seja, fora de qualquer classe ou objeto.
 * --
 * Isso ajuda a deixar claro que essas extensões não pertencem diretamente à classe original.
 * --
 * É comum organizá-las em arquivos separados (por exemplo, "ProdutoExt.kt"),
 * para manter o código mais limpo e organizado.
 */
fun main() {
    val p = Produto("Café", 9.5)

    // Acessando atributo de extensão
    println(p.descricao)

    // Chamando função de extensão
    if (p.estaCaro()) {
        println("Produto custa mais que 5 reais.")
    }
}