package character

import kotlin.random.Random

/**
 * Classe abstrata que representa um personagem no jogo.
 * Define atributos básicos como vida, ataque e defesa, além de métodos para ataque e dano.
 */
abstract class Character(
    /**
     * Quantidade de vida do personagem.
     */
    protected var health: Int,

    /**
     * Poder de ataque do personagem.
     */
    protected val attack: Int,

    /**
     * Poder de defesa do personagem.
     */
    protected val defense: Int
) {

    /**
     * Método abstrato que deve ser implementado por subclasses para definir o ataque do personagem.
     */
    abstract fun attack(): Int

    /**
     * Aplica dano ao personagem, considerando sua defesa.
     */
    fun receiveDamage(damage: Int) {
        // 25% de chance de desviar do ataque
        if (Random.nextDouble() < 0.25) {
            println("$this esquivou do ataque!")
            return
        }

        val damageTaken = maxOf(damage - defense, 0)
        health = maxOf(health - damageTaken, 0)

        println("$this recebeu $damageTaken de dano! Vida atual: $health")
    }

    /**
     * Verifica se o personagem ainda está vivo.
     */
    fun isAlive(): Boolean = health > 0
}
