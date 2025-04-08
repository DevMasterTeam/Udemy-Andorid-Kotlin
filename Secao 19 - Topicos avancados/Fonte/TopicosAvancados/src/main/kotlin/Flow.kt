import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * Flow - API do Kotlin para manipulação de streams de dados (fluxo de dados)
 * de forma assíncrona e reativa.
 * --
 * Flow é capaz de emitir valores e estes valores podem ser coletados.
 * --
 * Exemplos de uso
 * -> Leitura de dados (banco de dados, monitoramente de sensores)
 * -> Redes socias (postagens, curtidas, comentários)
 * */
fun main() {
    runBlocking {
        // Nomeando a variável como 'value' ao invés de it
        funcionalidadeFlowEmitindoValores().collect { value ->
            println(value)
        }
        println("------------")
        retornaListaDeValores()
            .onStart { println("Comecei a receber valores.") }
            .onCompletion { println("Terminei de receber valores.") }
            .onEach { it * 2 } // posso executar uma ação a cada valor recebido
            .collect { println(it) }
    }
}

// Flow é criado e dentro desse fluxo valores são emitidos.
fun funcionalidadeFlowEmitindoValores(): Flow<Int> = flow {
    for (i in 1..5) {
        delay(1000)
        emit(i)
    }
}

// Lista convertida para Flow
fun retornaListaDeValores(): Flow<Int> = listOf(1, 4, 8, 23, 7).asFlow()