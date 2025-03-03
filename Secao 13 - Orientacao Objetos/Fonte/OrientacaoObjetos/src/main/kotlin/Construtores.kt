/**
 * Um construtor é um método chamado no momento que uma classe é instanciada.
 * -----------
 * Nesse exemplo existe um construtor primário e um secundário.
 * Existem alguns detalhes nos contrutores secundários que devem ser observados.
 * 1. Atributos não podem ser val nem var, devem somente ter o nome do atributo e o tipo.
 * 2. Não podem ser acessados dentro ou fora da classe.
 * Se existe algum valor a mais no construtor secundário,
 * variável no escopo da classe deve ser declarada para que o valor possa ser usado futuramente.
 * ------------
 * this referencia o objeto gerado pela classe.
 */
fun main() {
    val p1 = Pessoa4("Davy Jones")
    val p2 = Pessoa4("Davy Jones", 54)
}

class Pessoa4(val nome: String) {

    // Atributo dentro da classe que o construtor secundário fará a atribuição
    // Em casos desse tipo, é importante prestar atenção que a variável pode ser nula
    // caso seja iniciada pelo construtor primário.
    private var idade: Int? = null

    constructor(nome: String, idade: Int) : this(nome) {
        this.idade = idade
    }

    fun saudacoes() {
        println("Meu nome é $nome e tenho $idade")
    }

}

// Exemplo de classe que não pode ser instanciada de fora dela
class Pessoa5 private constructor(val nome: String) {
    // Nesse caso, os parâmetros ficam dentro do "construtor"
}