import character.Character

/**
 * Classe responsável por gerenciar batalhas entre personagens no jogo.
 */
class Battle {

    companion object {

        private lateinit var hero: Character
        private lateinit var enemy: Character

        /**
         * Executa uma rodada de combate entre o jogador e o inimigo.
         * O jogador ataca primeiro, seguido pelo inimigo (se ainda estiver vivo).
         * A batalha termina quando um dos personagens é derrotado.
         */
        fun fight() {
            val damageHero = hero.attack()
            enemy.receiveDamage(damageHero)

            if (!enemy.isAlive()) {
                println("$enemy foi derrotado!")
                // Exercicio: Se o inimigo foi derrotado, como interropter este código?
            }

            val damageEnemy = enemy.attack()
            hero.receiveDamage(damageEnemy)

            if (!hero.isAlive()) {
                println("$hero foi derrotado!")
                // Exercicio: Se o herói foi derrotado, como interropter este código?
            }

            println()
        }

        /**
         * Inicia a batalha entre dois personagens.
         */
        fun start(p1: Character, p2: Character) {
            hero = p1
            enemy = p2

            println("\nBatalha iniciada entre $p1 e $p2\n")
        }
    }
}