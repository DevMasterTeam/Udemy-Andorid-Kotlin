import kotlinx.coroutines.*

/**
 * Coroutines pertencem a um escopo, o qual representa o ambiente em que elas são gerenciadas.
 * --
 * Dentro desse ambiente, cada Coroutine possui um contexto.
 * O contexto contém os aspectos relacionados ao controle de execução da Coroutine.
 * Um dos elementos principais do contexto é um Job, que gerencia a vida útil e seu Dispatcher.
 *--
 * Dispatcher determina qual thread ou threads a coroutine vai utilizar para execução.
 *
 * Dispatchers.Main: Usado para operações que precisam atualizar a interface do usuário.
 * Dispatchers.IO: Usado para operações de leitura/escrita, como acesso a arquivos, banco de dados ou chamadas de rede.
 * Dispatchers.Default: Usado para operações computacionais pesadas.
 * Dispatchers.Unconfined: Inicia na thread atual, mas pode mudar de thread durante a execução.
 *
 * Quando nenhum Dispatcher é especificado, Default é usado.
 * */
fun main() {

    runBlocking {
        funcionalidadeCoroutineScope()
        funcionalidadeComDispatchers()
    }

}

suspend fun funcionalidadeCoroutineScope() {

    // Criando manualmente o escopo de uma Coroutine.
    coroutineScope {
        // Coroutine número 1
        launch {
            delay(500)
            launch { println("Olá, Mundo! (1)") }
        }
        // Coroutine número 2
        launch {
            delay(800)
            println("Olá, Mundo! (2)")
        }
    }
    println("Olá, Mundo! (3)")
}

suspend fun funcionalidadeComDispatchers() {
    coroutineScope {
        launch(Dispatchers.IO) {
            println("Especificando IO.")
        }
        launch(Dispatchers.Default) {
            println("Especificando Default.")
        }
        launch(Dispatchers.Unconfined) {
            println("Especificando Unconfined.")
        }

        // Teremos problema, pois não temos interface no programa atual
        // Comum uso em aplicações Android
        /*launch(Dispatchers.Main) {
            println("Especificando Main.")
        }*/
    }

    // Outra maneira de criar o escopo de uma Coroutine.
    CoroutineScope(Dispatchers.IO).launch {
        println("Especificando IO.")
    }
}