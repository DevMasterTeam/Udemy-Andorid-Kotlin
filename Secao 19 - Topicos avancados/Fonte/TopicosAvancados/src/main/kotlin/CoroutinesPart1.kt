import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * O processamento assíncrono/paralelo/concorrente é uma abordagem onde uma tarefa é iniciada,
 * mas o sistema não precisa esperar que ela termine para continuar executando outras operações.
 * Isso melhora a eficiência e a escalabilidade, pois permite que múltiplas tarefas sejam processadas
 * ao mesmo tempo sem bloquear a execução principal.
 * --
 * Exemplos de aplicação
 * -> Banco de dados
 * -> API
 * -> Tarefas pesadas
 * --
 * Coroutines podem ser pensadas como threads leves. Não são threads por si só.
 * */
fun main() {
    runBlocking {
        launch {
            helloWorld()
        }
    }

    // Só é possível fazer a chamada de uma função 'suspend' dentro de outra função suspend
    // ou dentro de uma Coroutine
    // helloWorld()
}

/**
 * suspend é uma função que pode ser pausada e retomada.
 * */
suspend fun helloWorld(): Int {
    delay(3500)
    println("Olá, Mundo!")

    // Podem ter retorno assim como qualquer outra função
    return 0
}

fun funcionalidadeLaunch() {
    // launch vai criar uma nova Coroutine que executa SEM bloquear a thread principal
    runBlocking {
        // Nova Coroutine que vai esperar três segundos e depois imprimir "dentro do launch"
        launch {
            delay(3000)
            println("Dentro do launch")
        }
        // Fora do launch é impresso primeiro, pois é independente da funcionalidade launch
        println("Fora do launch")
    }

    // Só é executado quando runBlocking termina a execução
    println("Fora do blocking")
}

fun funcionalidadeRunBlocking() {
    // Capaz de executar coroutines em um bloco de código que bloqueia a thread atual até que a execução da coroutine termine
    // Não é aconselhado para códigos em produção, uma vez que bloqueia a thread principal até que a execução seja completa
    runBlocking {
        delay(4000)
        println("Dentro do blocking")
    }

    // Mesmo que o código acima leve 4 segundos para executar, a linha abaixo SÓ acontece após o término do código acima.
    println("Fora do blocking")
}