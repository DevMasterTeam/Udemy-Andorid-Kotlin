import character.*
import kotlin.concurrent.thread

// Exercicio: Ponto de entrada está com muitas responsabilidades. Como melhorar usando funções?
fun main() {

    // Escolha do personagem hero
    val hero: Character
    var character: String

    do {
        println("Escolha seu personagem: ")
        println("Arqueiro (A)")
        println("Mago (M)")
        print("Sua escolha: ")
        character = readlnOrNull()?.trim().toString().lowercase()
    } while (character !in listOf("a", "m"))

    // Exercicio: É possível evitar comparação de Strings? Alguma outra opção mais segura?
    if (character == "a") {
        hero = Archer(100, 15, 10)
    } else {
        hero = Wizard(100, 15, 10)
    }

    // Cria o inimigo
    val enemy = Goblin(100, 18, 5)

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