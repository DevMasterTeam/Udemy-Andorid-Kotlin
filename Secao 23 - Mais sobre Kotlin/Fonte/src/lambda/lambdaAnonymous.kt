package lambda;

/**
 * Lambdas se comportam como funções anônimas e podem ser passadas como parâmetros.
 * --
 * Conversões de classe anônima para lambda só acontecem quando a interface é em Java.
 * E somente se a interface Java possuir um único método.
 * Neste caso, o Kotlin consegue fazer a conversão do código de maneira que instancie a interface
 * em uso. Isso se chama "SAM Conversion - Single Abstract Method"
 */

interface EventListener {
    fun click()
}

class FormRegister {
    fun clickJava(click: EventListenerJava) {}
    fun clickKotlin(click: EventListener) {}
}

class Main {
    private val kotlinVariable = 10
    fun main() {

        FormRegister().clickJava(object : EventListenerJava {
            override fun click() {
                // Classe anônima cria seu próprio escopo - Não disponível
                // println(this.kotlinVariable)
            }
        })

        // Convertido para lambda
        // Lambda pode usar o escopo da classe em que está inserido
        FormRegister().clickJava {
            println(this.kotlinVariable)
        }

        // Não pode ser convertido pra lambda
        FormRegister().clickKotlin(object : EventListener {
            override fun click() {
                println("Somente inteface Java com um método pode ser convertido para lambda.")
            }
        })
    }
}