package character

/**
 * Classe que representa um Arqueiro no jogo.
 */
class Archer(health: Int, attack: Int, defense: Int) : Character(health, attack, defense) {

    /**
     * Retorna o poder de ataque do Arqueiro.
     */
    override fun attack(): Int = attack

    /**
     * Representação textual do Arqueiro.
     */
    override fun toString(): String {
        // Exercicio: Como melhorar para imprimir o nome do herói?
        return super.toString()
    }
}
