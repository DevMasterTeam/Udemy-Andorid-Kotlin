package character

/**
 * Classe que representa um Goblin no jogo.
 */
class Goblin(health: Int, attack: Int, defense: Int) : Character(health, attack, defense) {

    /**
     * Retorna o poder de ataque do character.Goblin.
     */
    override fun attack(): Int = attack

    /**
     * Representação textual do character.Goblin.
     */
    override fun toString(): String = "Green Goblin"
}