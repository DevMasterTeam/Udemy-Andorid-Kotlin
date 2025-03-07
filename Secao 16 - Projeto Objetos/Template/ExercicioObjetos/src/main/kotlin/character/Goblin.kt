package character

/**
 * Classe que representa um Goblin no jogo.
 */
class Goblin(health: Int, attack: Int, defense: Int) : Character(health, attack, defense) {

    /**
     * Retorna o poder de ataque do Goblin.
     */
    override fun attack(): Int = attack

    /**
     * Representação textual do Goblin.
     */
    override fun toString(): String {
        // Exercicio: Como melhorar para imprimir o nome do inimigo?
        return super.toString()
    }
}