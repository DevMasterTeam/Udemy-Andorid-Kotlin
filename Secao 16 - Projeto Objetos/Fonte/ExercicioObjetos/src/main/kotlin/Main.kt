import character.*
import utils.CharacterOptions
import kotlin.concurrent.thread

fun main() {

    // Escolha do personagem hero
    val hero = chooseCharacter()

    // Cria o inimigo
    val enemy = createEnemy()

    // Inicia a batalha
    Battle.start(hero, enemy)

    // Sistema de jogo - Executa até que acabe a batalha
    thread {
        while (hero.isAlive() && enemy.isAlive()) {
            Battle.fight()
            Thread.sleep(2500)
        }
    }
}

/**
 * Exibe um menu para o usuário escolher um personagem entre Arqueiro (A) e Mago (M).
 * O método garante que a entrada seja válida antes de retornar a escolha correspondente.
 */
private fun getUserInputForCharacter(): CharacterOptions {
    var character: String

    do {
        println("Escolha seu personagem: ")
        println("Arqueiro (A)")
        println("Mago (M)")
        print("Sua escolha: ")
        character = readlnOrNull()?.trim().toString().lowercase()
    } while (character !in listOf("a", "m"))

    return if (character == "a") CharacterOptions.Archer else CharacterOptions.Wizard
}

/**
 * Cria e retorna uma instância do personagem escolhido pelo usuário.
 */
private fun chooseCharacter(): Character {
    return when (getUserInputForCharacter()) {
        CharacterOptions.Archer -> Archer(100, 15, 10)
        CharacterOptions.Wizard -> Wizard(100, 15, 10)
    }
}

/**
 * Cria inimigo.
 */
private fun createEnemy(): Character = Goblin(100, 18, 5)