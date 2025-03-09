/**
 * Uma propriedade by lazy só recebe seu valor quando de fato acessada
 * --
 * Poderia ser o carregamento de qualquer tipo de dado, Int, String, etc. Da mesma maneira,
 * pode ser o carregamento de uma informação do banco de dados, API, etc, que tem um custo maior para se obter.
 * Dessa maneia, é melhor que a informação seja de fato necessária antes de carregá-la. 
 * Assim, o poder de processamento só é usado quando de fato for requisitado.
 * */

class Authentication {
    val key: String by lazy {
        "5f4g1rdqa¨&*%v54%fg87q%41sdf"
    }
}

class ConfigManager {
    val config: Map<String, String> by lazy {
        println("Carregando configurações do arquivo...")
        loadConfigurationFromFile()
    }

    private fun loadConfigurationFromFile(): Map<String, String> {
        return mapOf(
            "api_base_url" to "https://api.example.com",
            "api_key" to "123456789"
        )
    }
}

fun main() {
    println(Authentication().key)
    println(ConfigManager().config)
}