/**
 * Uma classe tem necessariamente um nome e não precisa ter métodos ou atributos.
 * ---
 * Os métodos são considerados comportamentos da classe e também são referenciados como funções.
 * Os atributos são as características da classe, são os dados que ela carrega.
 * ---
 * Ao se criar a instância de uma classe, é criado um objeto.
 * Esse objeto será alocado na memória e referenciado pela variável usada para istanciá-lo.
 */

fun main() {
    // Instância da classe
    val pessoa1: Pessoa1 = Pessoa1()

    // Instância e acesso a atributos
    val pessoa2: Pessoa2 = Pessoa2("Tony", 1975)
    pessoa2.nome
}

/**
 * Uma classe sem atributos ou funções, pode ser declarada sem chaves.
 */
class Pessoa1

/**
 * Os mesmos conceitos de var e val se aplicam as classes.
 * Atributos que uma vez são atribuídos valor e não mudam podem ser declarados como val.
 * Atributos cujo valor muda constantemente devem ser declarados como var
 * Se não há 'corpo' para uma classe (atributos ou funções), não há necessidade de chaves.
 */
class Pessoa2(var nome: String, val anoNascimento: Int)

/**
 * Aqui, a estrutura de uma classe com atributos e métodos.
 * Novo atributo fome e também há a possibilidade de atribuir um valor padrão (default).
 */
class Pessoa3(var nome: String, val anoNascimento: Int, val fome: Boolean = false) {
    fun saudacao() {
        println("Meu nome é ${this.nome}")
    }
}